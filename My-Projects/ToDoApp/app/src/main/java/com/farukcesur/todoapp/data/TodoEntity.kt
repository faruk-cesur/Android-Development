package com.farukcesur.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
/*
| Satır                              | Açıklama                                                              |
| ---------------------------------- | --------------------------------------------------------------------- |
| `@Entity`                          | Room’a bu sınıfın veritabanında bir tablo olduğunu söyler.            |
| `tableName = "todo_table"`         | Oluşacak tablonun ismini belirliyoruz.                                |
| `@PrimaryKey(autoGenerate = true)` | Her görevin kendine ait benzersiz ID'si olacak, otomatik artacak.     |
| `title` ve `description`           | Kullanıcının girdiği görev adı ve açıklama.                           |
| `isDone`                           | Görevin tamamlanıp tamamlanmadığını tutar. Varsayılan olarak `false`. |
*/

@Entity(tableName = "todo_table")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,
    val description: String,
    val isDone: Boolean = false
)