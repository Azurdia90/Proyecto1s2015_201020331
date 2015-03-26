__author__ = 'Cristian'

class Nodo_vuelo(object):

    def __init__(self, iden, ls, lll, hs, hll, fs, fll, canp, cosp, cane, cose, cant, cost, ei):
        self.iden = iden
        self.lugar_salida = ls
        self.lugar_llegada = lll
        self.hora_salida = hs
        self.hora_llegada = hll
        self.fecha_salida = fs
        self.fecha_llegada = fll
        self.cantidad_primera = canp
        self.costo_primera = cosp
        self.cantidad_ejecutiva = cane
        self.costo_ejecutiva = cose
        self.cantidad_turista = cant
        self.costo_turista = cost
        self.estado = ei

        self.hijo_der = None
        self.hijo_izq = None

        self.fe = 0
        self.h = 0

    def get_iden(self):
        return self.iden
    def get_lugar_salida(self):
        return self.lugar_salida
    def get_lugar_llegada(self):
        return self.lugar_llegada
    def get_fecha_salida(self):
        return self.fecha_salida
    def get_fecha_llegada(self):
        return self.fecha_llegada
    def get_hora_salida(self):
        return self.hora_salida
    def get_hora_llegada(self):
        return self.hora_llegada
    def get_cantidad_primera(self):
        return self.cantidad_primera
    def get_costo_primera(self):
        return self.costo_primera
    def get_cantidad_ejecutiva(self):
        return self.cantidad_ejecutiva
    def get_costo_ejecutiva(self):
        return self.costo_ejecutiva
    def get_cantidad_turista(self):
        return self.cantidad_turista
    def get_costo_turista(self):
        return self.costo_turista
    def get_hijo_derecho(self):
        return self.hijo_der
    def get_hijo_izquierdo(self):
        return self.hijo_izq
    def get_estado(self):
        return  self.estado
    def get_fe(self):
        return self.fe
    def get_h(self):
        return self.h

    def set_iden(self, id):
        self.id = id
    def set_lugar_salida(self, ls):
        self.lugar_salida = ls
    def set_lugar_llegada(self, lll):
        self.lugar_llegada = lll
    def set_fecha_salida(self, fs):
        self.fecha_salida = fs
    def set_fecha_llegada(self, fll):
        self.fecha_llegada = fll
    def set_hora_salida(self, hs):
        self.hora_salida = hs
    def set_hora_llegada(self, hll):
        self.hora_llegada = hll
    def set_cantidad_primera(self, canp):
        self.cantidad_primera = canp
    def set_costo_primera(self, cosp):
        self.costo_primera = cosp
    def set_cantidad_ejecutiva(self, cane):
        self.cantidad_ejecutiva = cane
    def set_costo_ejecutiva(self, cose):
        self.costo_ejecutiva = cose
    def set_cantidad_turista(self, cant):
        self.cantidad_turista = cant
    def set_costo_turista(self, cost):
        self.costo_turista = cost
    def set_hijo_derecho(self, h_d):
        self.hijo_der = h_d
    def set_hijo_izquierdo(self, h_i):
        self.hijo_izq = h_i
    def set_estado(self, es):
        self.estado = es
    def set_fe(self, fe):
        self.fe = fe
    def set_h(self, h):
        self.h = h
pass