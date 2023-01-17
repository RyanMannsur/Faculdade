transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/ryane/OneDrive/Documentos/atividades/projeto1/comportamental {C:/Users/ryane/OneDrive/Documentos/atividades/projeto1/comportamental/farol.v}

