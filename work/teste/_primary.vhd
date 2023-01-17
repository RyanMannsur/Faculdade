library verilog;
use verilog.vl_types.all;
entity teste is
    port(
        instrucao       : in     vl_logic_vector(7 downto 0);
        clock           : in     vl_logic;
        valor_ula       : in     vl_logic_vector(7 downto 0);
        reg_write       : in     vl_logic;
        mem_read        : in     vl_logic;
        mem_write       : in     vl_logic;
        counter         : in     vl_logic_vector(7 downto 0);
        reg1            : out    vl_logic_vector(7 downto 0);
        reg2            : out    vl_logic_vector(7 downto 0);
        valorr1         : in     vl_logic_vector(7 downto 0);
        valorr2         : in     vl_logic_vector(7 downto 0)
    );
end teste;
