package com.sandra.game.services;

import com.sandra.game.repositories.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Character searchCharacter(int position){
        return menuRepository.findByPosition(position);
    }

    public Character yourBestScore(){
        return menuRepository.findFirstOrderByFriendshipBar();
    }


}
