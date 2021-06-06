package ar.edu.unahur.obj2.tareas

interface Tarea {
    fun horasNecesariasParaFinalizacion() : Double
    fun costoDeTarea() : Double
}
class TareaSimple(val horasEstimadasParaFinalizacion:Double,val responsable:Empleado,val empleadosAsignados:List<Empleado>,val costoInfraestructura:Double): Tarea {
    override fun horasNecesariasParaFinalizacion()=this.horasEstimadasParaFinalizacion/this.empleadosAsignados.size
    override fun costoDeTarea()=this.costoInfraestructura+(sueldoEmpleados()*horasNecesariasParaFinalizacion())
    fun sueldoEmpleados()=this.empleadosAsignados.sumBy { it.sueldoPorHora }*this.horasNecesariasParaFinalizacion()
    fun sueldoResponsable()=horasEstimadasParaFinalizacion
}
class Empleado(val sueldoPorHora:Int)
