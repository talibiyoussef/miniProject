package fr.isep62071.smallproject.backend

enum class WashingMachineStatus {
    OCCUPIED, FREE, BROKEN
}

enum class WashingMachineCycle {
    ECO, NORMAL, INTENSE
}

data class WashingMachine(
    val id: Int,
    var status: WashingMachineStatus,
    var cycle: WashingMachineCycle,
    var timeRemaining: Int? = null
) {
    init {
        if (status != WashingMachineStatus.OCCUPIED) {
            timeRemaining = null
        }
    }
}

fun main() {
    val repository = WashingMachineRepository("mongodb+srv://youssefatalibi:YOHA8nWWEX7GWtkW@cluster0.kjatpbg.mongodb.net/")

    val newMachine = WashingMachine(1, WashingMachineStatus.FREE, WashingMachineCycle.NORMAL)
    repository.insertWashingMachine(newMachine)

    val washingMachineId = 1;
    val washingMachine = repository.getWashingMachineById(washingMachineId)
    println("Retrieved: $washingMachine")



}
