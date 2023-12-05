// Sudoku.h
#ifndef SUDOKU_H
#define SUDOKU_H

#include <string>

const int VELIKOST = 9;

// Funkce pro manipulaci s herním polem
void vypsatHerniPole(int herniPole[VELIKOST][VELIKOST]);
bool nacistHerniPole(std::string soubor, int herniPole[VELIKOST][VELIKOST]);
void ulozitHru(int herniPole[VELIKOST][VELIKOST]);
void nacistUlozenouHru(int herniPole[VELIKOST][VELIKOST]);
void vytvoritNovyPlan(int herniPole[VELIKOST][VELIKOST]);

// Funkce pro herní logiku
bool platneCislo(int herniPole[VELIKOST][VELIKOST], int radek, int sloupec, int cislo);
void uzivatelskyVstup(int herniPole[VELIKOST][VELIKOST]);
bool overitVitezstvi(int herniPole[VELIKOST][VELIKOST]);

// Funkce hlavního menu
void hlavniMenu();

#endif // SUDOKU_H
