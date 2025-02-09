package org.wikipedia.homeworks.homework04

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }

    operator fun invoke(init: Schedule.() -> Unit) {
        this.init()
    }

    var currentDay: Days? = null

    fun monday(init: Schedule.() -> Unit) {
        currentDay = Days.MONDAY
        this.init()
        currentDay = null
    }

    fun tuesday(init: Schedule.() -> Unit) {
        currentDay = Days.TUESDAY
        this.init()
        currentDay = null
    }

    fun wednesday(init: Schedule.() -> Unit) {
        currentDay = Days.WEDNESDAY
        this.init()
        currentDay = null
    }

    fun thursday(init: Schedule.() -> Unit) {
        currentDay = Days.THURSDAY
        this.init()
        currentDay = null
    }

    fun friday(init: Schedule.() -> Unit) {
        currentDay = Days.FRIDAY
        this.init()
        currentDay = null
    }

    fun saturday(init: Schedule.() -> Unit) {
        currentDay = Days.SATURDAY
        this.init()
        currentDay = null
    }

    fun sunday(init: Schedule.() -> Unit) {
        currentDay = Days.SUNDAY
        this.init()
        currentDay = null
    }

    infix fun String.to(endTime: String): Pair<LocalTime, LocalTime> {
        val startTime = LocalTime.parse(this, timeFormatter)
        val end = LocalTime.parse(endTime, timeFormatter)
        return startTime to end
    }

    infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
        val (startTime, endTime) = this
        currentDay?.let { addSchedule(it, ScheduleEntity(lesson, startTime, endTime)) }
    }
}

fun main() {

    val schedule = Schedule()

    // Так добавляется расписание без DSL
    schedule.addSchedule(Days.MONDAY, ScheduleEntity("Biology", LocalTime.of(10, 30), LocalTime.of(11, 10)))
    schedule.addSchedule(Days.MONDAY, ScheduleEntity("Chemistry", LocalTime.of(11, 15), LocalTime.of(11, 55)))

    // Так добавляется расписание с использованием DSL
    schedule {

        monday {
            "10:30" to "11:10" schedule "Biology"
            "11:15" to "11:55" schedule "Chemistry"
            "09:00" to "09:40" schedule "Mathematics"
            "09:45" to "10:25" schedule "History"
        }

        tuesday {
            "09:00" to "09:40" schedule "English"
            "09:45" to "10:25" schedule "Geography"
            "11:15" to "11:55" schedule "Art"
            "10:30" to "11:10" schedule "Physics"
        }

        wednesday {
            "11:15" to "11:55" schedule "Biology"
            "09:00" to "09:40" schedule "Literature"
            "10:30" to "11:10" schedule "History"
            "09:45" to "10:25" schedule "Mathematics"
        }

        thursday {
            "11:15" to "11:55" schedule "Physics"
            "10:30" to "11:10" schedule "Geography"
            "09:00" to "09:40" schedule "Chemistry"
            "09:45" to "10:25" schedule "English"
        }

        friday {
            "09:45" to "10:25" schedule "Literature"
            "11:15" to "11:55" schedule "History"
            "09:00" to "09:40" schedule "Art"
            "10:30" to "11:10" schedule "Mathematics"
        }
    }

    println(schedule.toString())
}
