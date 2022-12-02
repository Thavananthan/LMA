package com.example.lma.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lma.model.Category;
import com.example.lma.model.Course;
import com.example.lma.model.CourseShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    //repository
    private CourseShopRepository repository;

    //live data
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Course>> coursesOfSelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseShopRepository(application);
    }
    public LiveData<List<Category>> getAllCategories(){
        allCategories = repository.getCategories();
        return allCategories;
    }

    public LiveData<List<Course>> getCoursesOfSelectedCategory(int categoryId){
        coursesOfSelectedCategory = repository.getCourses(categoryId);

        return  coursesOfSelectedCategory;
    }

    public void addNewCourse(Course course){
        repository.insertCourse(course);
    }

    public void updateCourse(Course course){
        repository.updateCourse(course);
    }

    public void deleteCourse(Course course){
        repository.deleteCourse(course);
    }

    public void addNewCategory(Category category){
        repository.insertCategory(category);
    }

    public void updateCategory(Category category){
        repository.updateCategory(category);
    }
    public void deleteCategory(Category category){
        repository.deleteCategory(category);
    }


}
