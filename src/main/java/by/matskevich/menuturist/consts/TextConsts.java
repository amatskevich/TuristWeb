package by.matskevich.menuturist.consts;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author a_matskevich
 */
@Named(value = "textConsts")
@ApplicationScoped
public class TextConsts implements Serializable {
    
    public static final String LIST_DISHES = "Доступные блюда";
    public static final String DISH = "Блюдо";
    public static final String NUMBER_SIGN = "№";
    public static final String BREAKFAST = "Завтрак";
    public static final String LUNCH = "Обед";
    public static final String DINNER = "Ужин";
    public static final String DROP_HERE = "Перетащите блюдо";
    public static final String MENU = "Меню";
    public static final String EXSPORT_IN_XLS = "Экспорт в XLS";
    public static final String DAY_OF_CAMPING = "День похода";
    public static final String TIME_TO_EAT = "Время приема";
    public static final String AMOUNT_PEOPLE = "Количество едоков: ";
    public static final String ADD_DAYMENU = "Добавить день";
    public static final String CALCULATE_INGR = "Рассчитать провиант";
    public static final String NECESSARY_INGR = "Необходимые продукты";
    public static final String NAME = "Название";
    public static final String AMOUNT = "Количество";
    public static final String UNIT = "Ед. измерения";
    public static final String NO_RECORDS = "Нет записей";

    public String getLIST_DISHES() {
        return LIST_DISHES;
    }

    public String getDISH() {
        return DISH;
    }

    public String getNUMBER_SIGN() {
        return NUMBER_SIGN;
    }

    public String getBREAKFAST() {
        return BREAKFAST;
    }

    public String getLUNCH() {
        return LUNCH;
    }

    public String getDINNER() {
        return DINNER;
    }

    public String getDROP_HERE() {
        return DROP_HERE;
    }

    public String getMENU() {
        return MENU;
    }

    public String getEXSPORT_IN_XLS() {
        return EXSPORT_IN_XLS;
    }

    public String getDAY_OF_CAMPING() {
        return DAY_OF_CAMPING;
    }

    public String getTIME_TO_EAT() {
        return TIME_TO_EAT;
    }

    public String getAMOUNT_PEOPLE() {
        return AMOUNT_PEOPLE;
    }

    public String getADD_DAYMENU() {
        return ADD_DAYMENU;
    }

    public String getCALCULATE_INGR() {
        return CALCULATE_INGR;
    }

    public String getNECESSARY_INGR() {
        return NECESSARY_INGR;
    }

    public String getNAME() {
        return NAME;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public String getUNIT() {
        return UNIT;
    }

    public String getNO_RECORDS() {
        return NO_RECORDS;
    }
    
}
