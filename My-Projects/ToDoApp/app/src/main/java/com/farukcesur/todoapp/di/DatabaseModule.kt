package com.farukcesur.todoapp.di

import android.content.Context
import androidx.room.Room
import com.farukcesur.todoapp.data.TodoDao
import com.farukcesur.todoapp.data.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
| Kod Parçası                             | Açıklama                                                       |
| --------------------------------------- | -------------------------------------------------------------- |
| `@Module`                               | Hilt'e bu sınıfın bağımlılıkları sağlayacağını söyler.         |
| `@InstallIn(SingletonComponent::class)` | Uygulama boyunca tek bir instance (singleton) olmasını sağlar. |
| `provideTodoDatabase(...)`              | Room veritabanını oluşturur.                                   |
| `provideTodoDao(...)`                   | Veritabanı üzerinden DAO'yu elde eder.                         |
*/

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(todoDatabase: TodoDatabase): TodoDao {
        return todoDatabase.getTodoDao()
    }
}
