library verilog;
use verilog.vl_types.all;
entity decodificador_c is
    port(
        A               : in     vl_logic;
        B               : in     vl_logic;
        C               : in     vl_logic;
        D               : in     vl_logic;
        S               : out    vl_logic_vector(7 downto 0)
    );
end decodificador_c;
