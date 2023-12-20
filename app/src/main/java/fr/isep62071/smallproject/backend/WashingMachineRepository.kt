package fr.isep62071.smallproject.backend

import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.set
import org.litote.kmongo.setTo

class WashingMachineRepository(connectionString: String) {
    private val client = KMongo.createClient(connectionString)
    private val database = client.getDatabase("Cluster0") // Replace with your database name
    private val collection = database.getCollection<WashingMachine>()

    fun getWashingMachineById(id: Int): WashingMachine? {
        return collection.findOne(WashingMachine::id eq id)
    }

    fun updateWashingMachineStatus(id: Int, newStatus: WashingMachineStatus) {
        collection.updateOne(
            WashingMachine::id eq id,
            set(WashingMachine::status setTo newStatus)
        )
    }

    fun insertWashingMachine(washingMachine: WashingMachine) {
        collection.insertOne(washingMachine)
    }

}
