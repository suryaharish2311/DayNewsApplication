package com.surya.daynewsapplication.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.surya.daynewsapplication.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {
    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(string: String): Source {
        return string.split(",").let {
            Source(
                id = it[0],
                name = it[1]
            )
        }
    }
}