transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/atividades/projeto2/mux4 {C:/Users/ryane/OneDrive/Documentos/atividades/projeto2/mux4/mux_41.v}
vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/atividades/projeto2/mux4 {C:/Users/ryane/OneDrive/Documentos/atividades/projeto2/mux4/mux_21.v}

