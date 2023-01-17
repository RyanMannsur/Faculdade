library verilog;
use verilog.vl_types.all;
entity addr is
    port(
        buswires        : in     vl_logic_vector(15 downto 0);
        addr_in         : in     vl_logic;
        reg_addr        : out    vl_logic_vector(7 downto 0)
    );
end addr;
