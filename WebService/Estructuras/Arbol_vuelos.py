__author__ = 'Cristian'

import Estructuras.Nodo_vuelo as nodo

class Arbol_vuelos(object):
    def __init__(self):
        self.root = None
        self.codigo = 'digraph Arbol1 { \n'
    def es_vacia(self, raiz):
        if raiz == None:
            return True
        else:
            return False
    def crear_arbol(self,iden,ls,lll,hs,hll,fs,fll,canp,cosp,cane,cose,cant,cost,ei):
        if self.root == None:
            self.root = nodo.Nodo_vuelo(iden, ls, lll, hs, hll, fs, fll, canp, cosp, cane, cose, cant, cost, ei)
        else:
            self.root = self.insertar_arbol(self.root,iden,ls,lll,hs,hll,fs,fll,canp,cosp,cane,cose,cant,cost,ei,True)
    def insertar_arbol(self,raiz,iden, ls, lll, hs, hll, fs, fll, canp, cosp, cane, cose, cant, cost, ei, ban):
        if self.es_vacia(raiz) == False:
            if(raiz.get_iden() > iden):
                izquierda = self.insertar_arbol(raiz.get_hijo_izquierdo(),iden,ls, lll, hs, hll, fs, fll, canp, cosp, cane, cose, cant, cost, ei,ban)
                raiz.set_hijo_izquierdo(izquierda)
                if ban == True:
                    if raiz.get_fe() == 0:
                        raiz.set_fe(-1)
                    elif raiz.get_fe() == 1:
                        raiz.set_fe(0)
                        ban = False
                    elif raiz.get_fe() == -1:
                        nodo_n1 = raiz.get_hijo_izquierdo()
                        if nodo_n1.get_fe() == -1:
                            raiz = self.rotacionII(raiz, nodo_n1)
                        else:
                            raiz = self.rotacion_ID(raiz, nodo_n1)
                        ban = False
            elif(raiz.get_iden() < iden):
                derecha = self.insertar_arbol(raiz.get_hijo_derecho(),iden, ls, lll, hs, hll, fs, fll, canp, cosp, cane, cose, cant, cost, ei,ban)
                raiz.set_hijo_derecho(derecha)
                if ban == True:
                    if raiz.get_fe() == 0:
                        raiz.set_fe(1)
                    elif raiz.get_fe() == 1:
                        nodo_n1 = raiz.get_hijo_derecho()
                        if nodo_n1.get_fe() == 1:
                            raiz = self.rotacion_DD(raiz, nodo_n1)
                        else:
                            raiz =  self.rotacion_DI(raiz, nodo_n1)
                        ban = False
                    elif raiz.get_fe() == -1:
                        raiz.set_fe(0)
                        ban = False
        else:
            raiz = nodo.Nodo_vuelo(iden, ls, lll, hs, hll, fs, fll, canp, cosp, cane, cose, cant, cost, ei)
            return raiz
        return raiz
    def rotacion_II(self, nodo_n, nodo_n1):
        nodo_n.set_hijo_izquierdo(nodo_n1.get_hijo_derecho())
        nodo_n1.set_hijo_derecho(nodo_n)
        if nodo_n1.get_fe() == -1:
            nodo_n.set_fe(0)
            nodo_n1.set_fe(0)
        else:
            nodo_n.set_fe(-1)
            nodo_n1.set_fe(-1)
        return nodo_n1

    def rotacion_DD(self, nodo_n, nodo_n1):
        nodo_n.set_hijo_derecho(nodo_n1.get_hijo_izquierdo())
        nodo_n1.set_hijo_izquierdo(nodo_n)
        if nodo_n1.get_fe()== 1:
            nodo_n.set_fe(0)
            nodo_n1.set_fe(0)
        else:
            nodo_n.set_fe(1)
            nodo_n1.set_fe(-1)
        return nodo_n1
    def rotacion_ID(self, nodo_n, nodo_n1):
        nodo_n2 = None
        nodo_n2 = nodo_n1.get_hijo_derecho()
        nodo_n.set_hijo_izquierdo(nodo_n2.get_hijo_derecho())
        nodo_n2.set_hijo_derecho(nodo_n)
        nodo_n1.set_hijo_derecho(nodo_n2.get_hijo_izquierdo())
        nodo_n2.set_hijo_izquierdo(nodo_n1)
        if nodo_n2.get_fe() == 1:
            nodo_n1.set_fe(-1)
        else:
            nodo_n1.set_fe(0)
        if nodo_n2.get_fe() == -1:
            nodo_n.set_fe(1)
        else:
            nodo_n.set_fe(0)
        nodo_n2.set_fe(0)
        return nodo_n2
    def rotacion_DI(self, nodo_n, nodo_n1):
        nodo_n2 = None
        nodo_n.set_hijo_derecho(nodo_n2.get_hijo_izquierdo())
        nodo_n2.set_hijo_izquierdo(nodo_n)
        nodo_n1.set_hijo_izquierdo(nodo_n2.get_hijo_derecho())
        nodo_n2.set_hijo_derecho(nodo_n1)
        if nodo_n2.get_fe() == 1:
            nodo_n.set_fe(-1)
        else:
            nodo_n.get_fe(0)
        if nodo_n2.get_fe() == -1:
            nodo_n1.set_fe(1)
        else:
            nodo_n1.set_fe(0)
        nodo_n2.set_fe(0)
        return nodo_n2

    def imprimir_vuelos(self):
        retornar = []
        if self.root != None:
            self.imprimir(self.root, retornar)
            return retornar
        else:
            retornar.append({'id':0, 'lugar salida':'Ninguno','lugar llegada':'Ninguno','hora salida':0,'hora llegada':0, 'fecha salida':0, 'fecha llegada': 0,'cantidad primera':0,'costo primera':0,'cantidad ejecutiva':0,'costo ejcutiva':0,'cantidad turista':0,'costo turista':0 })
            return retornar
    def imprimir(self, raiz, retornar):
        if self.es_vacia(raiz)!= True:
            self.imprimir(raiz.get_hijo_izquierdo(),retornar)
            retornar.append({'id':raiz.get_iden(),'lugar salida':raiz.get_lugar_salida(),'lugar llegada':raiz.get_lugar_llegada(),'hora salida':raiz.get_hora_salida(),'hora llegada':raiz.get_hora_llegada(),'fecha salida':raiz.get_fecha_salida(),'fecha llegada':raiz.get_fecha_llegada(),'cantidad primera':raiz.get_cantidad_primera(),'costo primera':raiz.get_costo_primera(),'cantidad ejecutiva':raiz.get_cantidad_ejecutiva(),'costo ejecutiva':raiz.get_costo_ejecutiva(),'cantidad turista':raiz.get_cantidad_turista(),'costo turista':raiz.get_costo_turista()})
            self.imprimir(raiz.get_hijo_derecho(),retornar)
    def buscar_vuelo(self, iden):
        if self.root !=None:
            retornar = self.buscar(self.root, iden)
            return retornar
        else:
            retornar = {'id':0, 'lugar salida':'Ninguno','lugar llegada':'Ninguno','hora salida':0,'hora llegada':0, 'fecha salida':0, 'fecha llegada': 0,'cantidad primera':0,'costo primera':0,'cantidad ejecutiva':0,'costo ejcutiva':0,'cantidad turista':0,'costo turista':0 }
            return retornar
    def buscar(self, raiz, iden):
        retornar = None
        if self.es_vacia(raiz) == False:
            if raiz.get_iden() == iden:
                retornar = {'id':raiz.get_iden(),'lugar salida':raiz.get_lugar_salida(),'lugar llegada':raiz.get_lugar_llegada(),'hora salida':raiz.get_hora_salida(),'hora llegada':raiz.get_hora_llegada(),'fecha salida':raiz.get_fecha_salida(),'fecha llegada':raiz.get_fecha_llegada(),'cantidad primera':raiz.get_cantidad_primera(),'costo primera':raiz.get_costo_primera(),'cantidad ejecutiva':raiz.get_cantidad_ejecutiva(),'costo ejecutiva':raiz.get_costo_ejecutiva(),'cantidad turista':raiz.get_cantidad_turista(),'costo turista':raiz.get_costo_turista(),'estado':raiz.get_estado()}
                return retornar
            elif raiz.get_iden() > iden:
                retornar = self.buscar(raiz.get_hijo_izquierdo(), iden)
            elif raiz.get_iden() < iden:
                retornar = self.buscar(raiz.get_hijo_derecho(), iden)
        return retornar
    def modificar_vuelo(self,iden,hs,hll,fs,fll,canp,cosp,cane,cose,cant,cost,ei):
        if self.root != None:
            self.modificar(self.root,iden,hs,hll,fs,fll,canp,cosp,cane,cose,cant,cost,ei)
            return 'Modificacion realizada'
        else:
            return 'No existe el objeto'

    def modificar(self,raiz,iden,hs,hll,fs,fll,canp,cosp,cane,cose,cant,cost,ei):
        if self.es_vacia(raiz) == False:
            if raiz.get_iden() == iden:
                raiz.set_iden(iden)
                raiz.set_hora_salida(hs)
                raiz.set_hora_llegada(hll)
                raiz.set_fecha_salida(fs)
                raiz.set_fecha_llegada(fll)
                raiz.set_cantidad_primera(canp)
                raiz.set_costo_primera(cosp)
                raiz.set_cantidad_ejecutiva(cane)
                raiz.set_costo_ejecutiva(cose)
                raiz.set_cantidad_turista(cant)
                raiz.set_costo_turista(cost)
                raiz.set_estado(ei)
            elif raiz.get_iden() > iden:
                self.modificar(raiz.get_hijo_izquierdo(),iden,hs,hll,fs,fll,canp,cosp,cane,cose,cant,cost,ei)
            elif raiz.get_iden() < iden:
                self.modificar(raiz.get_hijo_derecho(),iden,hs,hll,fs,fll,canp,cosp,cane,cose,cant,cost,ei)

    def eliminar_vuelo(self,iden):
        if self.root != None:
            self.eliminar(self.root, iden)
            return 'nodo eliminado'
        else:
            return 'arbol vacio'


    def recorrer_arbol(self, raiz):
        if raiz != None:
            print ("viene" + raiz.get_iden())
            self.recorrer_arbol(raiz.get_hijo_izquierdo())
            self.reocorrer_arbol(raiz.get_hijo_derecho())

    def graficar_arbol(self, raiz):
        if self.es_vacia(raiz) == False:
            self.graficar_arbol(raiz.get_hijo_izquierdo())
            self.codigo = self.codigo + 'nodo'+raiz.get_iden()+'[shape=ellipse, label="'+raiz.get_iden()+'"];\n'
            if raiz.get_hijo_izquierdo() != None:
                self.codigo = self.codigo +'nodo'+raiz.get_iden()+'->nodo'+raiz.get_hijo_izquierdo().get_iden()+';\n'
            if raiz.get_hijo_derecho() != None:
                self.codigo = self.codigo+'nodo'+raiz.get_iden()+'->nodo'+raiz.get_hijo_derecho().get_iden()+';\n'
            self.graficar_arbol(raiz.get_hijo_derecho())


