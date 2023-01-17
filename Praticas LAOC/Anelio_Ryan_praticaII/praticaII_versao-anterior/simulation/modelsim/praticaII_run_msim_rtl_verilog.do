transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/fsm.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/romlpm.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/ramlpm.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/ir.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/mux.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/a.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/alu.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/g.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/addr.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/dout.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/counter.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/registrador.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/processador.v}

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII {C:/Users/ryane/OneDrive/Documentos/quartus/teste/praticaII/test_bench.v}

vsim -t 1ps -L altera_ver -L lpm_ver -L sgate_ver -L altera_mf_ver -L altera_lnsim_ver -L cycloneii_ver -L rtl_work -L work -voptargs="+acc"  test_bench

add wave *
view structure
view signals
run -all
