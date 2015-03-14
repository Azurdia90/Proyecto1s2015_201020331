__author__ = 'Cristian'

import Estructuras.Raiz_aeropuerto as raiz
import Estructuras.Nodo_aeropuerto as nodo

class Nodo_lista_usuario(object):
#constructor de la clase lista doble
    def __init__(self):
        self.root = raiz()

    def es_vacia(self, raiz):
        if raiz == None:
            return True

    def insertar(self, raiz, id, nombre, pais, contra):
        nuevo = nodo(id, nombre, pais, contra)
        if self.es_vacia(self, raiz)== False:
            if raiz.get_first().get_id() < id:
                nuevo.set_next(raiz.get_first())
                raiz.get_first.set_back(nuevo)
                raiz.set_first(nuevo)
            elif raiz.get_last().get_id() < id:
                nuevo.set_back(self, raiz)
                raiz.get_last().set_next(nuevo)
                raiz.set_last(nuevo)
        else:
            raiz.set_first(nuevo)
            raiz.set_last(nuevo)

    def imprimir(self):
        if self.root.get_first() == None:
            print("raiz vacia")
        else:
            aux = self.root.get_first()
            while(aux != None):
                print(aux.get_id())
                aux = aux.get_next()

