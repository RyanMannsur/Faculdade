library verilog;
use verilog.vl_types.all;
entity memoria_instrucoes is
    port(
        counter         : in     vl_logic_vector(7 downto 0);
        clock           : in     vl_logic;
        instrucao_entrada: in     vl_logic_vector(7 downto 0);
        instrucao_saida : out    vl_logic_vector(7 downto 0)
    );
end memoria_instrucoes;
