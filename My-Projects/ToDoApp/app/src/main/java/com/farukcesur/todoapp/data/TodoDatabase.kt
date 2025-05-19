package com.farukcesur.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

/*
| Satır                       | Açıklama                                                                          |
| --------------------------- | --------------------------------------------------------------------------------- |
| `@Database(...)`            | Room’a bu sınıfın bir veritabanı olduğunu bildirir.                               |
| `entities = [...]`          | Veritabanında kullanılacak tabloları belirtiriz. Şu an sadece `TodoEntity`.       |
| `version = 1`               | Veritabanı versiyonudur. İleride tablo yapısı değişirse artırılır.                |
| `exportSchema = false`      | Şema dosyası oluşturulmaması talimatıdır. Geliştirici için daha sade bir ayardır. |
| `abstract fun getTodoDao()` | Room’un, bizim yazdığımız DAO arayüzünü tanımasını sağlar.                        |
*/

@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun getTodoDao(): TodoDao
}