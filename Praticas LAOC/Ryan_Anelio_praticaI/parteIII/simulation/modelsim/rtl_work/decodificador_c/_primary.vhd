library verilog;
use verilog.vl_types.all;
entity decodificador_c is
    port(
        \in\            : in     vl_logic_vector(3 downto 0);
        S               : out    vl_logic_vector(7 downto 0)
    );
end decodificador_c;
