__author__ = 'Cristian'

class Nodo_aeropuerto(object):
#constructor de la clase nodo de la lista aeropuertos
    def __init__(self, i, n, p, c):
        self.id = i
        self.nombre_aeropuerto = n
        self.pais_origen = p
        self.contraseña = c

        self.next = None
        self.back = None

    def _init_(self):
        self.id = None
        self.nombre_aeropuerto = None
        self.pais_origen = None
        self.contraseña = None

        self.next = None
        self.back = None

#metodos get de la clase nodo de la lista aeropuertos
    def get_id(self):
        return self.id
    def get_elemento(self):
        return self.nombre_aeropuerto
    def getpais_origen(self):
        return self.pais_origen
    def get_contraseña(self):
        return self.contraseña

#metodos set de la clase nodo de la lista aeropuertos
    def set_id(self, id):
        self.id = id
    def set_aeropuerto(self, aeropuerto):
        self.nombre_aeropuerto = aeropuerto
    def set_pais_origen(self, pais):
        self.pais_origen = pais
    def set_contraseña(self, contraseña):
        self.contraseña = contraseña
pass#fin de la clase nodo_aeropuerto