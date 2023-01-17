library verilog;
use verilog.vl_types.all;
entity g is
    port(
        clock           : in     vl_logic;
        alu_reg         : in     vl_logic_vector(15 downto 0);
        g_in            : in     vl_logic;
        g_reg           : out    vl_logic_vector(15 downto 0)
    );
end g;
