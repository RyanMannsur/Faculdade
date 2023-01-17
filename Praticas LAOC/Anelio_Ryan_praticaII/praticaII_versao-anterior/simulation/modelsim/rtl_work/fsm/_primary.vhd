library verilog;
use verilog.vl_types.all;
entity fsm is
    generic(
        T0              : vl_logic_vector(0 to 2) := (Hi0, Hi0, Hi0);
        T1              : vl_logic_vector(0 to 2) := (Hi0, Hi0, Hi1);
        T2              : vl_logic_vector(0 to 2) := (Hi0, Hi1, Hi0);
        T3              : vl_logic_vector(0 to 2) := (Hi0, Hi1, Hi1);
        T4              : vl_logic_vector(0 to 2) := (Hi1, Hi0, Hi0);
        T5              : vl_logic_vector(0 to 2) := (Hi1, Hi0, Hi1)
    );
    port(
        clock           : in     vl_logic;
        ir              : in     vl_logic_vector(15 downto 0);
        run             : in     vl_logic;
        resetn          : in     vl_logic;
        ir_in           : out    vl_logic;
        r0_in           : out    vl_logic;
        r1_in           : out    vl_logic;
        r2_in           : out    vl_logic;
        r3_in           : out    vl_logic;
        r4_in           : out    vl_logic;
        r5_in           : out    vl_logic;
        r6_in           : out    vl_logic;
        r7_in           : out    vl_logic;
        pc_inc          : out    vl_logic;
        pc_in           : out    vl_logic;
        \select\        : out    vl_logic_vector(3 downto 0);
        a_in            : out    vl_logic;
        g_in            : out    vl_logic;
        addr_in         : out    vl_logic;
        dout_in         : out    vl_logic;
        ula             : out    vl_logic_vector(1 downto 0);
        wren            : out    vl_logic;
        done            : out    vl_logic
    );
    attribute mti_svvh_generic_type : integer;
    attribute mti_svvh_generic_type of T0 : constant is 1;
    attribute mti_svvh_generic_type of T1 : constant is 1;
    attribute mti_svvh_generic_type of T2 : constant is 1;
    attribute mti_svvh_generic_type of T3 : constant is 1;
    attribute mti_svvh_generic_type of T4 : constant is 1;
    attribute mti_svvh_generic_type of T5 : constant is 1;
end fsm;
