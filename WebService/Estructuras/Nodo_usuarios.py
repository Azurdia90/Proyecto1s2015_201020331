__author__ = 'Cristian'

class Nodo_usuarios(object):

    def __init__(self,n,c,nick,dir,tel,tar,dir_actual):
        self.nombre = n
        self.contrasena = c
        self.nickname = nick
        self.direccion = dir
        self.telefono = tel
        self.tarjeta_credito = tar
        self.direccion_actual = dir_actual

        self.hijo_der = None
        self.hijo_izq = None

        self.fe = 0


    def get_nombre(self):
        return self.nombre
    def get_contrasena(self):
        return self.contrasena
    def get_nickname(self):
        return self.nickname
    def get_direccion(self):
        return self.direccion
    def get_telefono(self):
        return self.telefono
    def get_tarjeta_credito(self):
        return self.tarjeta_credito
    def get_direccion_actual(self):
        return self.direccion_actual
    def get_hijo_derecho(self):
        return self.hijo_der
    def get_hijo_izquierdo(self):
        return self.hijo_izq
    def get_fe(self):
        return self.fe

    def set_nombre(self,n):
        self.nombre = n
    def set_contrasena(self,c):
        self.contrasena = c
    def set_nickname(self,n):
        self.nickname = n
    def set_direccion(self,d):
        self.direccion = d
    def set_telefono(self,t):
        self.telefono = t
    def set_tarjeta_credito(self,c):
        self.tarjeta_credito = c
    def set_direccion_actual(self,a):
        self.direccion_actual = a
    def set_hijo_derecho(self,hd):
        self.hijo_der = hd
    def set_hijo_izquierdo(self,hi):
        self.hijo_izq = hi
    def set_fe(self,fe):
        self.fe=fe

