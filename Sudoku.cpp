// Sudoku.cpp
#include "Sudoku.h"
#include <iostream>
#include <fstream>

// Funkce pro tisk hracího pole
void tiskHracihoPole(int hraciPole[VELIKOST][VELIKOST]) {
    for (int i = 0; i < VELIKOST; ++i) {
        for (int j = 0; j < VELIKOST; ++j) {
            std::cout << hraciPole[i][j] << " ";
        }
        std::cout << std::endl;
    }
}

// Funkce pro načtení hracího pole ze souboru
bool nacistHraciPole(std::string soubor, int hraciPole[VELIKOST][VELIKOST]) {
    std::ifstream file(soubor);
    if (!file.is_open()) return false;

    for (int i = 0; i < VELIKOST; ++i) {
        for (int j = 0; j < VELIKOST; ++j) {
            file >> hraciPole[i][j];
        }
    }

    return true;
}

void ulozitHru(int hraciPole[VELIKOST][VELIKOST]) {
    std::string souborUlozit;
    std::cout << "Zadejte název souboru pro uložení: ";
    std::cin >> souborUlozit;

    std::ofstream file(souborUlozit);
    if (!file.is_open()) {
        std::cout << "Chyba při ukládání hry." << std::endl;
        return;
    }

    for (int i = 0; i < VELIKOST; i++) {
        for (int j = 0; j < VELIKOST; j++) {
            file << hraciPole[i][j] << " ";
        }
        file << std::endl;
    }
    file.close();
}

void nacistUlozenouHru(int hraciPole[VELIKOST][VELIKOST]) {
    std::string souborNacist;
    std::cout << "Zadejte název souboru pro načtení: ";
    std::cin >> souborNacist;

    std::ifstream file(souborNacist);
    if (!file.is_open()) {
        std::cout << "Chyba při načítání hry." << std::endl;
        return;
    }

    for (int i = 0; i < VELIKOST; i++) {
        for (int j = 0; j < VELIKOST; j++) {
            file >> hraciPole[i][j];
        }
    }
}

void vytvoritNovyPlan(int hraciPole[VELIKOST][VELIKOST]) {
    std::cout << "Zadejte nové hrací pole, řádek po řádku:\n";
    for (int i = 0; i < VELIKOST; i++) {
        for (int j = 0; j < VELIKOST; j++) {
            std::cin >> hraciPole[i][j];
        }
    }
}

// Funkce pro ověření, zda lze číslo umístit na pozici
bool cisloPlatne(int hraciPole[VELIKOST][VELIKOST], int radek, int sloupec, int cislo) {
    // Kontrola řádku
    for (int x = 0; x < VELIKOST; x++) {
        if (hraciPole[radek][x] == cislo) {
            return false;
        }
    }

    // Kontrola sloupce
    for (int x = 0; x < VELIKOST; x++) {
        if (hraciPole[x][sloupec] == cislo) {
            return false;
        }
    }

    // Kontrola 3x3 podmřížky
    int zacatekRadku = radek - radek % 3;
    int zacatekSloupce = sloupec - sloupec % 3;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (hraciPole[i + zacatekRadku][j + zacatekSloupce] == cislo) {
                return false;
            }
        }
    }

    return true;
}

void vstupUzivatele(int hraciPole[VELIKOST][VELIKOST]) {
    int radek, sloupec, cislo;
    std::cout << "Zadejte řádek, sloupec a číslo (např: 1 3 5): ";//2 2 3
    std::cin >> radek >> sloupec >> cislo;

    // Uprava pro indexy pole
    radek--; //1
    sloupec--;//1

    if (cisloPlatne(hraciPole, radek, sloupec, cislo)) {
        hraciPole[radek][sloupec] = cislo;
    } else {
        std::cout << "Neplatné číslo pro tuto pozici!\n";
    }
}

bool overitVitezstvi(int hraciPole[VELIKOST][VELIKOST]) {
    for (int i = 0; i < VELIKOST; i++) {
        for (int j = 0; j < VELIKOST; j++) {
            if (hraciPole[i][j] == 0 || !cisloPlatne(hraciPole, i, j, hraciPole[i][j])) {
                return false;
            }
        }
    }
    return true;
}

// Funkce hlavního menu
void hlavniMenu() {
    int hraciPole[VELIKOST][VELIKOST] = {0};
    int volba;

    while (true) {
        std::cout << "Menu Sudoku\n";
        std::cout << "1. Načíst uloženou hru\n";
        std::cout << "2. Hrát\n";
        std::cout << "3. Uložit hru\n";
        std::cout << "4. Vytvořit nový plán hry\n";
        std::cout << "5. Načíst hrací pole ze souboru\n"; // Změněno na Načíst hrací pole ze souboru
        std::cout << "6. Odejít\n";
        std::cout << "Vyberte možnost: ";
        std::cin >> volba;

        switch (volba) {
            case 1:
                nacistUlozenouHru(hraciPole);
                break;
            case 2: {
                bool hraVPrubehu = true;
                while (hraVPrubehu && !overitVitezstvi(hraciPole)) {
                    tiskHracihoPole(hraciPole);
                    vstupUzivatele(hraciPole);
                    hraVPrubehu = overitVitezstvi(hraciPole) ? false : true;
                }
                if (overitVitezstvi(hraciPole)) {
                    std::cout << "Gratulujeme! Dokončili jste Sudoku!" << std::endl;
                }
                break;
            }
            case 3:
                ulozitHru(hraciPole);
                break;
            case 4:
                vytvoritNovyPlan(hraciPole);
                break;
            case 5: {
                std::string souborHraciPole;
                std::cout << "Zadejte název souboru s hracím polem: ";
                std::cin >> souborHraciPole;
                if (!nacistHraciPole(souborHraciPole, hraciPole)) {
                    std::cout << "Chyba při načítání hracího pole ze souboru." << std::endl;
                }
                break;
            }
            case 6:
                return; // Opustit program
            default:
                std::cout << "Neplatná volba!" << std::endl;
        }
    }
}
