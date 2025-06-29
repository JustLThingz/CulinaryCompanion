package co.uk.bbk.culinarycompanion.data

import kotlinx.coroutines.flow.Flow

class RecipeRepository(private val recipeDao: RecipeDao) {

    fun getRecipesByCategory(category: String): Flow<List<Recipe>> {
        return recipeDao.getRecipesByCategory(category)
    }

    fun searchRecipesInCategory(category: String, searchQuery: String): Flow<List<Recipe>> {
        return recipeDao.searchRecipesInCategory(category, searchQuery)
    }

    suspend fun getRecipeById(recipeId: Long): Recipe? {
        return recipeDao.getRecipeById(recipeId)
    }

    suspend fun insertRecipe(recipe: Recipe): Long {
        return recipeDao.insertRecipe(recipe)
    }

    suspend fun updateRecipe(recipe: Recipe) {
        recipeDao.updateRecipe(recipe)
    }

    suspend fun deleteRecipe(recipe: Recipe) {
        recipeDao.deleteRecipe(recipe)
    }

    suspend fun deleteRecipeById(recipeId: Long) {
        recipeDao.deleteRecipeById(recipeId)
    }
}