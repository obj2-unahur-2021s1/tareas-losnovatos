package ar.edu.unahur.obj2.tareas

abstract class Tarea(val responsable: Empleado) {
    abstract fun horasNecesariasParaFinalizacion() : Int
    abstract fun costoDeTarea() : Double
    abstract fun nominaDeEmpleados(): List<Empleado>
}
class Simple(val horasEstimadas: Int, responsable:Empleado, val empleadosAsignados:List<Empleado>, val costoInfraestructura:Double): Tarea(responsable) {
    override fun horasNecesariasParaFinalizacion()=this.horasEstimadas/this.empleadosAsignados.size
    override fun costoDeTarea()=this.costoInfraestructura + sueldoTotalEmpleados() + sueldoResponsable()
    override fun nominaDeEmpleados() = empleadosAsignados.plusElement(responsable)

    fun sueldoTotalEmpleados()=this.empleadosAsignados.sumByDouble { this.horasNecesariasParaFinalizacion() * it.sueldoPorHora }
    fun sueldoResponsable()= horasEstimadas * responsable.sueldoPorHora
}

class DeIntegracion(responsable: Empleado, val tareas: List<Tarea>):Tarea(responsable) {
    override fun horasNecesariasParaFinalizacion()= this.horasNecesariasDeSubtareas() + this.horasDeReunionDePlanificacion()
    fun horasNecesariasDeSubtareas() = tareas.sumBy { it.horasNecesariasParaFinalizacion() }
    fun horasDeReunionDePlanificacion() = this.horasNecesariasDeSubtareas() / 8
    override fun costoDeTarea()= this.costosDeSubtareas() + this.bonusDeResponsable()
    override fun nominaDeEmpleados() = this.nominaDeEmpleadosDeSubtareas().plusElement(responsable)
    fun nominaDeEmpleadosDeSubtareas() = tareas.map { it.nominaDeEmpleados() }.flatten()
    fun costosDeSubtareas() = tareas.sumByDouble { it.costoDeTarea() }
    fun bonusDeResponsable() = this.costosDeSubtareas() * 0.03
}

class Empleado(val sueldoPorHora:Double)
