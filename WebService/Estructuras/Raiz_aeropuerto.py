__author__ = 'Cristian'

import Estructuras.Nodo_aeropuerto as nodo

class Raiz_aeropuerto(object):
#constructor de la clase raiz aeropuertos
    def __init__(self):
        self.first = None
        self.last = None
    #metodos set de la clase
    def get_first(self):
        return self.first
    def get_last(self):
        return self.last
    #metodos get de la clase
    def set_first(self, first):
        self.first = first
    def set_last(self, last):
        self.last = last
pass #fin de la clase raiz aeropuertos