library verilog;
use verilog.vl_types.all;
entity pc_counter is
    port(
        clock           : in     vl_logic;
        endereco        : out    vl_logic_vector(7 downto 0)
    );
end pc_counter;
