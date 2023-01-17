library verilog;
use verilog.vl_types.all;
entity a is
    port(
        clock           : in     vl_logic;
        buswires        : in     vl_logic_vector(15 downto 0);
        a_in            : in     vl_logic;
        reg_a           : out    vl_logic_vector(15 downto 0)
    );
end a;
