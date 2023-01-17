library verilog;
use verilog.vl_types.all;
entity banco_registradores is
    port(
        clock           : in     vl_logic;
        reg_write       : in     vl_logic;
        endereco_reg1   : in     vl_logic_vector(1 downto 0);
        endereco_reg2   : in     vl_logic_vector(1 downto 0);
        data_in         : in     vl_logic_vector(7 downto 0);
        valor_reg1      : in     vl_logic_vector(7 downto 0);
        valor_reg2      : in     vl_logic_vector(7 downto 0);
        valorr1         : out    vl_logic_vector(7 downto 0);
        velorr2         : out    vl_logic_vector(7 downto 0)
    );
end banco_registradores;
