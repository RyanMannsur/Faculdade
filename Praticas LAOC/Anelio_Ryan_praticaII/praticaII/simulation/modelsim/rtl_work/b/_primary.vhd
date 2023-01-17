library verilog;
use verilog.vl_types.all;
entity b is
    port(
        opecode         : in     vl_logic_vector(1 downto 0);
        reg_alu         : in     vl_logic_vector(15 downto 0);
        btrue           : out    vl_logic
    );
end b;
