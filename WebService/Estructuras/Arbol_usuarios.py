__author__ = 'Cristian'

import Estructuras.Nodo_usuarios as nodo

class Arbol_usuarios(object):
    def __init__(self):
        self.root = None
        self.codigo = 'digraph Arbol1 { \n'
    def es_vacia(self, raiz):
        if raiz == None:
            return True
        else:
            return False
    def crear_arbol(self,n,c,nick,dir,tel,tar,dir_actual):
        if self.root == None:
            self.root = nodo.Nodo_usuarios(n,c,nick,dir,tel,tar,dir_actual)
        else:
            self.root = self.insertar_arbol(self.root,n,c,nick,dir,tel,tar,dir_actual,True)
    def insertar_arbol(self,raiz,n,c,nick,dir,tel,tar,dir_actual,ban):
        if self.es_vacia(raiz) == False:
            if(raiz.get_nickname() > nick):
                izquierda = self.insertar_arbol(raiz.get_hijo_izquierdo(),n,c,nick,dir,tel,tar,dir_actual,ban)
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
            elif(raiz.get_nickname() < nick):
                derecha = self.insertar_arbol(raiz.get_hijo_derecho(),n,c,nick,dir,tel,tar,dir_actual,ban)
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
            raiz = nodo.Nodo_usuarios(n,c,nick,dir,tel,tar,dir_actual)
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
            retornar.append({'nombre':'Ninguno', 'contraseña':'Ninguno','nickname':'Ninguno','direccion':'Ninguno','telefono':'Ninguno','tarjeta credito':'Ninguno', 'direccion actual': 'Ninguno'})
            return retornar
    def imprimir(self, raiz, retornar):
        if self.es_vacia(raiz)!= True:
            self.imprimir(raiz.get_hijo_izquierdo(),retornar)
            retornar.append({'nombre':raiz.get_nombre(),'contraseña':raiz.get_contrasena(),'nickname':raiz.get_nickname(),'direccion':raiz.get_direccion(),'telefono':raiz.get_telefono(),'tarjeta credito':raiz.get_tarjeta_credito(),'direccion actual':raiz.get_direccion_actual()})
            self.imprimir(raiz.get_hijo_derecho(),retornar)
    def buscar_usuario(self, nick):
        if self.root !=None:
            retornar = self.buscar(self.root, nick)
            return retornar
        else:
            retornar = {'nombre':'Ninguno', 'contraseña':'Ninguno','nickname':'Ninguno','direccion':'Ninguno','telefono':'Ninguno','tarjeta credito':'Ninguno', 'direccion actual': 'Ninguno'}
            return retornar
    def buscar(self, raiz,nick):
        retornar = None
        if self.es_vacia(raiz) == False:
            if raiz.get_nickname() == nick:
                retornar ={'nombre':raiz.get_nombre(),'contraseña':raiz.get_contrasena(),'nickname':raiz.get_nickname(),'direccion':raiz.get_direccion(),'telefono':raiz.get_telefono(),'tarjeta credito':raiz.get_tarjeta_credito(),'direccion actual':raiz.get_direccion_actual()}
                return retornar
            elif raiz.get_nickname() > nick:
                retornar = self.buscar(raiz.get_hijo_izquierdo(), nick)
            elif raiz.get_nickname() < nick:
                retornar = self.buscar(raiz.get_hijo_derecho(), nick)
        return retornar
    def modificar_usuario(self,n,c,nick,dir,tel,tar,dir_actual):
        if self.root != None:
            self.modificar(self.root,n,c,nick,dir,tel,tar,dir_actual)
            return 'Modificacion realizada'
        else:
            return 'No existe el objeto'

    def modificar(self,raiz,n,c,nick,dir,tel,tar,dir_actual):
        if self.es_vacia(raiz) == False:
            if raiz.get_nickname() == nick:
                raiz.set_nombre(n)
                raiz.set_contrasena(c)
                raiz.set_nickname(nick)
                raiz.set_direccion(dir)
                raiz.set_telefono(tel)
                raiz.set_tarjeta_credito(tar)
                raiz.set_direccion_actual(dir_actual)
            elif raiz.get_nickname() > nick:
                self.modificar(raiz.get_hijo_izquierdo(),n,c,nick,dir,tel,tar,dir_actual)
            elif raiz.get_nickname() < nick:
                self.modificar(raiz.get_hijo_derecho(),n,c,nick,dir,tel,tar,dir_actual)

    def eliminar_vuelo(self,nick):
        if self.root != None:
            self.eliminar(self.root,nick)
            return 'nodo eliminado'
        else:
            return 'arbol vacio'

    def graficar_arbol(self, raiz):
        if self.es_vacia(raiz) == False:
            self.graficar_arbol(raiz.get_hijo_izquierdo())
            self.codigo = self.codigo + 'nodo'+raiz.get_nickname()+'[shape=ellipse, label="'+raiz.get_nickname()+'"];\n'
            if raiz.get_hijo_izquierdo() != None:
                self.codigo = self.codigo +'nodo'+raiz.get_nickname()+'->nodo'+raiz.get_hijo_izquierdo().get_nickname()+';\n'
            if raiz.get_hijo_derecho() != None:
                self.codigo = self.codigo+'nodo'+raiz.get_nickname()+'->nodo'+raiz.get_hijo_derecho().get_nickname()+';\n'
            self.graficar_arbol(raiz.get_hijo_derecho())