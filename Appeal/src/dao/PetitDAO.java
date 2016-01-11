package dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import domain.Petit;

public interface PetitDAO {

    public void addPetit(Petit petit);

    public List<Petit> listPetit(String username);

    public void removePetit(Integer id);
    
    public List<Petit> listSearch(Petit petit, String username) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException;

	public Petit getPetit(Integer petitId);
}