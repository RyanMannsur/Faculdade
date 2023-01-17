-- EXERCICIO 01
SELECT LAST_NAME, HIRE_DATE
    FROM ALUNO.EMPLOYEES
    WHERE LAST_NAME like'R%';

-- EXERCICIO 02   
SELECT CONCAT(FIRST_NAME,CONCAT(' ',LAST_NAME)) NOME_COMPLETO
    FROM ALUNO.EMPLOYEES
    WHERE DEPARTMENT_ID = 60;

-- EXERCICIO 03  
SELECT UPPER(DEPARTMENT_NAME) NOME_DEPARTAMENTO
    FROM ALUNO.DEPARTMENTS
    WHERE DEPARTMENT_ID = 60;
    
-- EXERCICIO 04
SELECT FIRST_NAME ||' '|| LAST_NAME NOME_COMPLETO
    FROM ALUNO.EMPLOYEES
    WHERE HIRE_DATE >= '01/01/1999' AND HIRE_DATE <= '31/12/1999';
    
-- EXERCICIO 05 
SELECT FIRST_NAME,SALARY*12 SALARIO_ANUAL
    FROM ALUNO.EMPLOYEES
    WHERE SALARY BETWEEN 4000 AND 7000;
    
-- EXERCICIO 06
SELECT FIRST_NAME ||' '|| LAST_NAME NOME_COMPLETO
    FROM ALUNO.EMPLOYEES
    WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                FROM ALUNO.DEPARTMENTS
                                WHERE DEPARTMENT_NAME = 'Shipping');
                                
-- EXERCICIO 07
SELECT FIRST_NAME
    FROM ALUNO.EMPLOYEES
    WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                                FROM ALUNO.DEPARTMENTS
                                WHERE DEPARTMENT_NAME = 'Shipping')
    AND SALARY BETWEEN 5000 AND 8000 AND HIRE_DATE BETWEEN '01/01/1997' AND '31/12/1999';
    
-- EXERCICIO 08
SELECT FIRST_NAME ||' '|| LAST_NAME NOME_COMPLETO
    FROM ALUNO.EMPLOYEES
    WHERE MANAGER_ID = (SELECT EMPLOYEE_ID
                            FROM ALUNO.EMPLOYEES
                            WHERE FIRST_NAME = 'Steven' AND LAST_NAME = 'King');
                            

 -- EXERCICIO 09
 SELECT FIRST_NAME ||' '|| LAST_NAME NOME_COMPLETO, COUNTRY_NAME
    FROM ((ALUNO.EMPLOYEES E join ALUNO.DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID)
    join ALUNO.LOCATIONS L on D.LOCATION_ID = L.LOCATION_ID) join ALUNO.COUNTRIES C
    on C.COUNTRY_ID = L.COUNTRY_ID;
 
  -- EXERCICIO 10
 SELECT FIRST_NAME ||' '|| LAST_NAME NOME_COMPLETO
    FROM ((ALUNO.EMPLOYEES E join ALUNO.DEPARTMENTS D on D.DEPARTMENT_ID = E.DEPARTMENT_ID)
    join ALUNO.LOCATIONS L on D.LOCATION_ID = L.LOCATION_ID) join ALUNO.COUNTRIES C
    on C.COUNTRY_ID = L.COUNTRY_ID
    WHERE D.DEPARTMENT_NAME = 'Shipping' and E.SALARY > 2000 and
          E.HIRE_DATE BETWEEN '01/01/1999' and '31/12/2005';