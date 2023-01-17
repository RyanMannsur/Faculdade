library verilog;
use verilog.vl_types.all;
entity somador_4bits is
    port(
        numero1         : in     vl_logic_vector(3 downto 0);
        numero2         : in     vl_logic_vector(3 downto 0);
        resultado       : out    vl_logic_vector(4 downto 0)
    );
end somador_4bits;
