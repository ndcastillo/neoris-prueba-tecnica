PGDMP                      }            neorisDB    17.2    17.2     !           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            "           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            #           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            $           1262    16521    neorisDB    DATABASE     l   CREATE DATABASE "neorisDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE "neorisDB";
                     postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                     pg_database_owner    false            %           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                        pg_database_owner    false    4            �            1259    17221    cliente    TABLE     j  CREATE TABLE public.cliente (
    cliente_id bigint NOT NULL,
    direccion character varying(255),
    edad integer NOT NULL,
    genero character varying(255),
    id bigint,
    identificacion character varying(255),
    nombre character varying(255),
    telefono character varying(255),
    contrasena character varying(255),
    estado boolean NOT NULL
);
    DROP TABLE public.cliente;
       public         heap r       postgres    false    4            �            1259    17238    cliente_seq    SEQUENCE     u   CREATE SEQUENCE public.cliente_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.cliente_seq;
       public               postgres    false    4            �            1259    17228    cuenta    TABLE     �   CREATE TABLE public.cuenta (
    numero_cuenta bigint NOT NULL,
    cliente_id bigint,
    estado boolean NOT NULL,
    saldo double precision NOT NULL,
    tipo_cuenta character varying(255)
);
    DROP TABLE public.cuenta;
       public         heap r       postgres    false    4            �            1259    17233 
   movimiento    TABLE     �   CREATE TABLE public.movimiento (
    movimiento_id bigint NOT NULL,
    fecha date,
    numero_cuenta bigint,
    saldo double precision NOT NULL,
    tipo_movimiento character varying(255),
    valor double precision NOT NULL
);
    DROP TABLE public.movimiento;
       public         heap r       postgres    false    4            �            1259    17239    movimiento_seq    SEQUENCE     x   CREATE SEQUENCE public.movimiento_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.movimiento_seq;
       public               postgres    false    4                      0    17221    cliente 
   TABLE DATA           �   COPY public.cliente (cliente_id, direccion, edad, genero, id, identificacion, nombre, telefono, contrasena, estado) FROM stdin;
    public               postgres    false    217   x                 0    17228    cuenta 
   TABLE DATA           W   COPY public.cuenta (numero_cuenta, cliente_id, estado, saldo, tipo_cuenta) FROM stdin;
    public               postgres    false    218   6                 0    17233 
   movimiento 
   TABLE DATA           h   COPY public.movimiento (movimiento_id, fecha, numero_cuenta, saldo, tipo_movimiento, valor) FROM stdin;
    public               postgres    false    219   �       &           0    0    cliente_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.cliente_seq', 1, false);
          public               postgres    false    220            '           0    0    movimiento_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.movimiento_seq', 51, true);
          public               postgres    false    221            �           2606    17227    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cliente_id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public                 postgres    false    217            �           2606    17232    cuenta cuenta_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (numero_cuenta);
 <   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_pkey;
       public                 postgres    false    218            �           2606    17237    movimiento movimiento_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (movimiento_id);
 D   ALTER TABLE ONLY public.movimiento DROP CONSTRAINT movimiento_pkey;
       public                 postgres    false    219               �   x�e̽�0@���}�O/-����\nHMj�-RJ�Ooq2q>9��a�����K,���.䠔0S���졂��$���`���y�K�J�7��5PT����\�1}�d	�%m$C�����D�R���"��Lo����ew3�A�h��Ƒ�<o���R(uS#`�t�n�,�>^@         [   x�M�1
�@��1rY�W�߰=�FA�?F���Y�PiSJ�O붭�����[��s��c�c?��rT�:�\~G�c�w�&~blT���f         s   x�U�1�@��~8�3^l�� u�\AJ��0T\�+K��+�(�hQ#�pUSл�o�m(p�BW�>�*,�\�^m���q�Y$y&O����G��N����9�*�s��3�32�	4t(�     