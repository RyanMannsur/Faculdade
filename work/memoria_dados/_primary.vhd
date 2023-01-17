library verilog;
use verilog.vl_types.all;
entity memoria_dados is
    port(
        endereco        : in     vl_logic_vector(7 downto 0);
        clock           : in     vl_logic;
        mem_write       : in     vl_logic;
        mem_read        : in     vl_logic;
        valor_reg       : in     vl_logic_vector(7 downto 0);
        reg1            : out    vl_logic_vector(7 downto 0)
    );
end memoria_dados;
