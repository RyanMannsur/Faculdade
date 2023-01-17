library verilog;
use verilog.vl_types.all;
entity mux is
    port(
        r0              : in     vl_logic_vector(15 downto 0);
        r1              : in     vl_logic_vector(15 downto 0);
        r2              : in     vl_logic_vector(15 downto 0);
        r3              : in     vl_logic_vector(15 downto 0);
        r4              : in     vl_logic_vector(15 downto 0);
        r5              : in     vl_logic_vector(15 downto 0);
        r6              : in     vl_logic_vector(15 downto 0);
        r7              : in     vl_logic_vector(15 downto 0);
        rx              : in     vl_logic_vector(3 downto 0);
        ry              : in     vl_logic_vector(3 downto 0);
        reg_ir          : in     vl_logic_vector(15 downto 0);
        g               : in     vl_logic_vector(15 downto 0);
        \select\        : in     vl_logic_vector(3 downto 0);
        buswires        : out    vl_logic_vector(15 downto 0)
    );
end mux;
