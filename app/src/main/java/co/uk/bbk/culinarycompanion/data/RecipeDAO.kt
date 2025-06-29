package co.uk.bbk.culinarycompanion.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes WHERE category = :category ORDER BY title ASC")
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    suspend fun getRecipeById(recipeId: Long): Recipe?

    @Query("SELECT * FROM recipes WHERE category = :category AND title LIKE '%' || :searchQuery || '%' ORDER BY title ASC")
    fun searchRecipesInCategory(category: String, searchQuery: String): Flow<List<Recipe>>

    @Insert
    suspend fun insertRecipe(recipe: Recipe): Long

    @Update
    suspend fun updateRecipe(recipe: Recipe)

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Query("DELETE FROM recipes WHERE id = :recipeId")
    suspend fun deleteRecipeById(recipeId: Long)
}