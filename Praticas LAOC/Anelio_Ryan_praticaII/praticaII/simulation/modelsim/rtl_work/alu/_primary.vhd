library verilog;
use verilog.vl_types.all;
entity alu is
    port(
        reg_a           : in     vl_logic_vector(15 downto 0);
        buswires        : in     vl_logic_vector(15 downto 0);
        opcode          : in     vl_logic_vector(2 downto 0);
        reg_alu         : out    vl_logic_vector(15 downto 0)
    );
end alu;
