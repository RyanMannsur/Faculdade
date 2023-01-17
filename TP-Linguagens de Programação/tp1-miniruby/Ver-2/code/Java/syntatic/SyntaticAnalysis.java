package syntatic;

import java.io.IOException;

import interpreter.command.Command;
import lexical.Lexeme;
import lexical.LexicalAnalysis;
import lexical.LexicalException;
import lexical.TokenType;

public class SyntaticAnalysis {
    private LexicalAnalysis lex;
    private Lexeme current;

    public SyntaticAnalysis(LexicalAnalysis lex) throws LexicalException, IOException {
        this.lex = lex;
        this.current = lex.nextToken();
    }

    public Command start() throws LexicalException, IOException {
        procCode();
        eat(TokenType.END_OF_FILE);
        return null;
    }

    private void advance() throws LexicalException, IOException {
         System.out.println("Advanced (\"" + current.token + "\", " +
             current.type + ")");
        current = lex.nextToken();
    }

    private void eat(TokenType type) throws LexicalException, IOException {
         System.out.println("Expected (..., " + type + "), found (\"" + 
             current.token + "\", " + current.type + ")");
        if (type == current.type) {
            current = lex.nextToken();
        } else {
            showError();
        }
    }

    private void showError() {
        System.out.printf("%02d: ", lex.getLine());

        switch (current.type) {
            case INVALID_TOKEN:
                System.out.printf("Lexema inválido [%s]\n", current.token);
                break;
            case UNEXPECTED_EOF:
            case END_OF_FILE:
                System.out.printf("Fim de arquivo inesperado\n");
                break;
            default:
                System.out.printf("Lexema não esperado [%s]\n", current.token);
                break;
        }

        System.exit(1);
    }

    // <code> ::= { <cmd> } 
    private void procCode() throws LexicalException, IOException {  
        while(current.type == TokenType.IF ||
              current.type == TokenType.UNLESS ||
              current.type == TokenType.WHILE ||
              current.type == TokenType.UNTIL ||
              current.type == TokenType.FOR ||
              current.type == TokenType.PUTS || //se for output
              current.type == TokenType.PRINT ||
              current.type == TokenType.ID || //se for assign
              current.type == TokenType.OPEN_PAR)
              procCmd();
    }

    // <cmd> ::= <if> | <unless> | <while> | <until> | <for> | <output> | <assign>
    private void procCmd() throws LexicalException, IOException {
        if(current.type == TokenType.IF)
            procIf(); 
        else if(current.type == TokenType.UNLESS)
                procUnless();
        else if(current.type == TokenType.WHILE)
                procWhile();
        else if(current.type == TokenType.UNTIL)
                procUntil();
        else if(current.type == TokenType.FOR)
                procFor();
        else if(current.type == TokenType.PUTS ||current.type == TokenType.PRINT)
                procOutput(); 
        else if(current.type == TokenType.ID || current.type == TokenType.OPEN_PAR)
                procAssign();
        else
            showError();

    }

    // <assign> ::= <access> { ',' <access> } '=' <expr> { ',' <expr> } [ <post> ] ';'
    private void procAssign() throws LexicalException, IOException {
        procAccess();
        while(current.type == TokenType.COMMA){
            advance();
            procAccess();
        }
        eat(TokenType.ASSIGN);
        procExpr();
        while(current.type == TokenType.COMMA){
            advance();
            procExpr();
        }
        if(current.type == TokenType.IF || current.type == TokenType.UNLESS)
            procPost();
        eat(TokenType.SEMI_COLON);
    }

    // <output> ::= ( puts | print ) [ <expr> ] [ <post> ] ';'
    private void procOutput() throws LexicalException, IOException { 
        if(current.type == TokenType.PUTS)
            advance();
        else if(current.type == TokenType.PRINT)
            advance();
        else
            showError();
        if(current.type == TokenType.ADD || current.type == TokenType.SUB ||
           current.type == TokenType.GETS || current.type == TokenType.RAND ||
           current.type == TokenType.INTEGER || current.type == TokenType.STRING ||
           current.type == TokenType.OPEN_BRA || current.type == TokenType.ID ||
           current.type == TokenType.OPEN_PAR)
               procExpr();
        if(current.type == TokenType.IF || current.type == TokenType.UNLESS)
            procPost();
        eat(TokenType.SEMI_COLON);
    }

    // <if> ::= if <boolexpr> [ then ] <code> { elsif <boolexpr> [ then ] <code> } [ else <code> ] end
    private void procIf() throws LexicalException, IOException { 
        eat(TokenType.IF);
        procBoolExpr();
        if(current.type == TokenType.THEN)
            advance();
        procCode();
        while(current.type == TokenType.ELSIF){
            advance();
            procBoolExpr();
            if(current.type == TokenType.THEN)
                advance();
            procCode();
        }
        if(current.type == TokenType.ELSE){
            advance();
            procCode();
        }
        eat(TokenType.END);
    }

    // <while> ::= while <boolexpr> [ do ] <code> end
    private void procWhile() throws LexicalException, IOException { 
        eat(TokenType.WHILE);
        procBoolExpr();
        if(current.type == TokenType.DO)
            advance();
        procCode();
        eat(TokenType.END);
    }
    //<for> ::= for <id> in <expr> [ do ] <code> end 
    private void procFor() throws LexicalException, IOException {
        eat(TokenType.FOR);
        procId();
        eat(TokenType.IN);
        procExpr();
        if(current.type == TokenType.DO)
            advance();
        procCode();
        eat(TokenType.END);
    }

    //<post> ::= ( if | unless ) <boolexpr>
    private void procPost() throws LexicalException, IOException {
        if(current.type == TokenType.IF)
            advance();
        else if(current.type == TokenType.UNLESS)
                advance();
        else
            showError();
        procBoolExpr();
    }

    //<until> ::= until <boolexpr> [ do ] <code> end
    private void procUntil() throws LexicalException, IOException {
        eat(TokenType.UNTIL);
        procBoolExpr();
        if(current.type == TokenType.DO)
            advance();
        procCode();
        eat(TokenType.END);
    }

    // <boolexpr> ::= [ not ] <cmpexpr> [ (and | or) <boolexpr> ]
    private void procBoolExpr() throws LexicalException, IOException { 
        if(current.type == TokenType.NOT)
            advance();
        procCmpExpr();
        if(current.type == TokenType.AND || current.type == TokenType.OR){
            if(current.type == TokenType.AND){
                advance();
                procBoolExpr();
            }
            else if(current.type == TokenType.OR){
                    advance();
                    procBoolExpr();
                }
        }
        else if(current.type == TokenType.NOT || current.type == TokenType.OR){
            if(current.type == TokenType.NOT){
                advance();
                procBoolExpr();
            }
            else if(current.type == TokenType.OR){
                    advance();
                    procBoolExpr();
            }
            else
                showError();
        }
    }

    // <unless> ::= unless <boolexpr> [ then ] <code> [ else <code> ] end 
    private void procUnless() throws LexicalException, IOException { 
        eat(TokenType.UNLESS);
        procBoolExpr();
        if(current.type == TokenType.THEN)
            advance();
        procCode();
        if(current.type == TokenType.ELSE){
            advance();
            procCode();
        }
        eat(TokenType.END);
    }

    // <cmpexpr> ::= <expr> ( '==' | '!=' | '<' | '<=' | '>' | '>=' | '===' ) <expr>
    private void procCmpExpr() throws LexicalException, IOException { 
        procExpr();
        if(current.type == TokenType.EQUALS)
            advance();
        else if(current.type == TokenType.NOT_EQUALS)
                advance();
        else if(current.type == TokenType.LOWER)
                advance();
        else if(current.type == TokenType.GREATER)
                advance();
        else if(current.type == TokenType.LOWER_EQ)
                advance();
        else if(current.type == TokenType.GREATER_EQ)
                advance();
        else if(current.type == TokenType.CONTAINS)
                advance();
        else
            showError();
        procExpr();
    }

    // <expr> ::= <arith> [ ( '..' | '...' ) <arith> ]
    private void procExpr() throws LexicalException, IOException {
        procArith();
        if(current.type == TokenType.RANGE_WITH || current.type == TokenType.RANGE_WITHOUT){
            if(current.type == TokenType.RANGE_WITH)
                advance();
            else if(current.type == TokenType.RANGE_WITHOUT)
                    advance();
            else
                showError();
            if(current.type == TokenType.ADD || current.type == TokenType.SUB ||
                  current.type == TokenType.GETS || current.type == TokenType.RAND ||
                  current.type == TokenType.INTEGER || current.type == TokenType.STRING ||
                  current.type == TokenType.OPEN_BRA || current.type == TokenType.ID ||
                  current.type == TokenType.OPEN_PAR)
                  procArith();
        }
    }

    // <arith> ::= <term> { ('+' | '-') <term> }
    private void procArith() throws LexicalException, IOException {
        procTerm();
        while(current.type == TokenType.ADD || current.type == TokenType.SUB){
            if(current.type == TokenType.ADD){
                advance();
                procTerm();
            }
            else if(current.type == TokenType.SUB){
                advance();
                procTerm();
            }
            else
                showError();
        }
    }

    //<term> ::= <power> { ('*' | '/' | '%') <power> }
    private void procTerm() throws LexicalException, IOException{
        procPower();
        while(current.type == TokenType.MUL || current.type == TokenType.DIV ||
              current.type == TokenType.MOD){
            if(current.type == TokenType.MUL){
                advance();
                procPower();
            }
            else if(current.type == TokenType.DIV){
                    advance();
                    procPower();
            }
            else if(current.type == TokenType.MOD){
                    advance();
                    procPower();
                }
            else
                showError();
        }
    }

    //<power> ::= <factor> { '**' <factor> }
    private void procPower() throws LexicalException, IOException {
        procFactor();
        while(current.type == TokenType.EXP){
            advance();
            procFactor();
        }
    }

    //<factor> ::= [ '+' | '-' ] ( <const> | <input> | <access> ) [ <function> ]
    private void procFactor() throws LexicalException, IOException {
        if(current.type == TokenType.ADD)
            advance();
        else if(current.type == TokenType.SUB)
                advance();
        if(current.type == TokenType.INTEGER ||
           current.type == TokenType.STRING ||
           current.type == TokenType.OPEN_BRA)
            procConst();
        else if(current.type == TokenType.GETS ||
                current.type == TokenType.RAND)
                procInput();
        else if(current.type == TokenType.ID ||
                current.type == TokenType.OPEN_PAR)
                procAccess();
        else
            showError();
        if(current.type == TokenType.DOT)
            procFunction();
    }

    //<const> ::= <integer> | <string> | <array>
    private void procConst() throws LexicalException, IOException {
        if(current.type == TokenType.INTEGER)
            procInteger();
        else if(current.type == TokenType.STRING)
                procString();
        else if(current.type == TokenType.OPEN_BRA)
                procArray();
    }

    //<integer> ::= Integer;
    private void procInteger() throws LexicalException, IOException{
        eat(TokenType.INTEGER);
    }

    //<id> ::= id;
    private void procId() throws LexicalException, IOException{
        eat(TokenType.ID);
    }

    //<string> ::= String;
    private void procString() throws LexicalException, IOException{
        eat(TokenType.STRING);
    }

    //<input> ::= gets | rand
    private void procInput() throws LexicalException, IOException {
        if(current.type == TokenType.GETS)
            advance();
        else if(current.type == TokenType.RAND)
                advance();
        else
            showError();
    }

    //<array> ::= '[' [ <expr> { ',' <expr> } ] ']'
    private void procArray() throws LexicalException, IOException {
        eat(TokenType.OPEN_BRA);
        if( current.type == TokenType.ADD || current.type == TokenType.SUB ||
            current.type == TokenType.GETS || current.type == TokenType.RAND ||
            current.type == TokenType.INTEGER || current.type == TokenType.STRING ||
            current.type == TokenType.OPEN_BRA || current.type == TokenType.ID ||
            current.type == TokenType.OPEN_PAR){
                procExpr();
                while(current.type == TokenType.COMMA){
                    advance();
                    procExpr();
                }
            }
        eat(TokenType.CLOSE_BRA);
    }

    //<access> ::= ( <id> | '(' <expr> ')' ) [ '[' <expr> ']' ]
    private void procAccess() throws LexicalException, IOException {
        if(current.type == TokenType.ID)
            advance();
        else if(current.type == TokenType.OPEN_PAR){
                advance();
                procExpr();
                eat(TokenType.CLOSE_PAR);
            }
        else
            showError();
        if(current.type == TokenType.OPEN_BRA){
            advance();
            procExpr();
            eat(TokenType.CLOSE_BRA);
        }
    }
    //<function> ::= '.' ( length | to_i | to_s )
    private void procFunction() throws LexicalException, IOException{
        eat(TokenType.DOT);
        if(current.type == TokenType.LENGTH)
            advance();
        else if(current.type == TokenType.TO_INT)
                advance();
        else if(current.type == TokenType.TO_STR)
                advance();
        else
            showError();
    }
}