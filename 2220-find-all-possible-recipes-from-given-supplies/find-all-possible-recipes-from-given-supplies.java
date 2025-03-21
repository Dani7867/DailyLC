import java.util.*;

public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Graph representation
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        
        // Initialize in-degree for each recipe
        for (String recipe : recipes) {
            inDegree.put(recipe, 0); // Default value
        }

        // Build graph and in-degree map
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                // If the ingredient is not a supply, track its dependency
                if (!inDegree.containsKey(ingredient)) {
                    inDegree.put(ingredient, 0);
                }

                // Add recipe dependency
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipe);

                // Increase in-degree count for the recipe
                inDegree.put(recipe, inDegree.get(recipe) + 1);
            }
        }

        // Queue for BFS (starting with all supplies)
        Queue<String> queue = new LinkedList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));

        for (String supply : supplies) {
            queue.add(supply); // All supplies are initially available
        }

        // Result list
        List<String> result = new ArrayList<>();

        // Process ingredients and determine recipes that can be made
        while (!queue.isEmpty()) {
            String item = queue.poll();
            
            if (Arrays.asList(recipes).contains(item)) {
                result.add(item); // This is a valid recipe
            }

            // Reduce in-degree for dependent recipes
            if (graph.containsKey(item)) {
                for (String dependentRecipe : graph.get(item)) {
                    inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);

                    // If all ingredients are available, the recipe can be made
                    if (inDegree.get(dependentRecipe) == 0) {
                        queue.add(dependentRecipe);
                    }
                }
            }
        }

        return result;
    }
}

