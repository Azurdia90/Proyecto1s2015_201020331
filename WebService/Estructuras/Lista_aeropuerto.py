__author__ = 'Cristian'

import Estructuras.Nodo_aeropuerto as nodo

class Lista_aeropuerto(object):
#constructor de la clase lista doble
    def __init__(self, raiz):
        self.root = raiz

    def es_vacia(self):
        if self.root == None:
            return True

    def insertar(self, id, nombre, pais, contra):
        nuevo = nodo(id, nombre, pais, contra)
        if self.es_vacia() == False:
            if self.root.get_first().get_id() < id:
                nuevo.set_next(self.root.get_first())
                self.root.get_first.set_back(nuevo)
                self.root.set_first(nuevo)
            elif self.root.get_last().get_id() < id:
                nuevo.set_back(self, self.root.get_last())
                self.root.get_last().set_next(nuevo)
                self.root.set_last(nuevo)
        else:
            self.root.set_first(nuevo)
            self.root.set_last(nuevo)

    def devolver_ultimo(self):
        if self.root.get_last != None:
            return self.root.get_last().get_id()
        else:
            return None

    def imprimir(self):
        if self.root.get_first() == None:
            print("raiz vacia")
        else:
            aux = self.root.get_first()
            while(aux != None):
                print(aux.get_id())
                aux = aux.get_next()

