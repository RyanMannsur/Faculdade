library verilog;
use verilog.vl_types.all;
entity dout is
    port(
        buswires        : in     vl_logic_vector(15 downto 0);
        dout_in         : in     vl_logic;
        dout_reg        : out    vl_logic_vector(15 downto 0)
    );
end dout;
