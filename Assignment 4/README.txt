UTEID: dtn384; js62724;
FIRSTNAME: Danny; Jenna;
LASTNAME: Nguyen; Saleh;
CSACCOUNT: dannytn; jenna900;
EMAIL: dannytnguyen91@gmail.com; jas009@utexas.edu;

[Program 4]
[Description]

There is one java file, AES.java. In that file, we have hardcoded a 1D array for the sbox, inverse of the sbox, rcon, log table, and treverse log table. then in our main method, we read in an input file and see if we are encoding or decoding based on a flag. If we are encrypting then we call encrypt and create our expanded key. for the initial round, we call roundKey on our plaintext_matrix (initial matrix). then we loop 13 times and call subBytes, mixcol, then roundKey all on our state matrix (st)in that order each time we loop, then call those again for the last step. we print the state matrix after every funciton call. For decrypt, we essentially reverse this process except we use the inverse sbox and log table instead of the regular ones.

[Finish]
???????????

[Test Cases]
[Input of test 1]
[command line]
java AES e key plaintext

plaintext

00112233445566778899AABBCCDDEEFF

[Output of test 1]
The Plaintext is:
00 44 88 CC 
11 55 99 DD 
22 66 AA EE 
33 77 BB FF 

The CipherKey is:
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 

The expanded key is:
00000000 00000000 62626262 AAAAAAAA 6F0D6F0D 7DD77DD7 535E313C 96413CEB 9EC0F1CD 2B6A56BD 64A45598 6D0751EC E743168E 747322CE 105345CB 
00000000 00000000 63636363 FBFBFBFB 6C0F6C0F 8D768D76 545B3738 8AFC7107 AAF1C6FE 31CDBCBB 06F731CF BB76CA71 B04776B9 ED9B5120 F8BFC970 
00000000 00000000 63636363 FBFBFBFB 6C0F6C0F 8D768D76 EDE28E81 81F77A0C 8F6DE362 2BDCA6AA FD907311 A975D379 E8780B1A 0B7EADD4 0A727963 
00000000 00000000 63636363 FBFBFBFB CFACCFAC 6A916A91 C16DA20E C1503AAB 2845E7E9 DF8FB51E 5217F019 0B84312F 9C8B7B62 A125143B 179CE785 

After addRoundKey(0):
00112233445566778899AABBCCDDEEFF
After subBytes:
638293C31BFC33F5C4EEACEA4BC12816
After shiftRows:
63FCAC161BEE28C3C4C193F54B8233EA
After mixColumns:
6379E6D9F467FB76AD063CF4D2EB8AA3
After addRoundKey(1):
6379E6D9F467FB76AD063CF4D2EB8AA3
After subBytes:
FBB68E35BF850F38956FEBBFB5E97E0A
After shiftRows:
FB85EB0ABF6F7E3595E98E38B5B60FBF
After mixColumns:
98C6AD6C9FD673A1A7ED33B3006CC718
After addRoundKey(2):
FAA5CE0FFDB510C2C58E50D0620FA47B
After subBytes:
2D068B7654D5CA25A6195370AA764921
After shiftRows:
2DD5532154194976A6768B25AA06CA70
After mixColumns:
4C483DB3BCCB454063E9B246FF93B3C9
After addRoundKey(3):
E6B3C6481630BEBBC91249BD55684832
After subBytes:
8E6DB4524704AEEADDC93B7AFC455223
After shiftRows:
8E043B2347C95252DD45B4EAFC6DAE7A
After mixColumns:
13E899F0CE6ADCF6307ACE4280B55828
After addRoundKey(4):
7C84F53FC365D35A5F16A28D8DBA5784
After subBytes:
105FE6752E4D66BECF473A5D5DF45B5F
After shiftRows:
104D3A5F2E475B75CFF4E6BE5D5F665D
After mixColumns:
929BC8F9BB384084DAB3353F60142964
After addRoundKey(5):
EF1645936C4E3615A73EB855B7625FF5
After subBytes:
DF476EDC502F05595CB26CFCA9AACFE6
After shiftRows:
DF2F6CE650B2CFDC5CAA6E59A94705FC
After mixColumns:
5ED319EE7EB9182E6AF8C19279D4FB41
After addRoundKey(6):
0D87F42F20E2FA435BCF4F3045EC7A4F
After subBytes:
D717BF15B7982D1A398A84046ECEDA84
After shiftRows:
D7988484B78ADA1539CEBF1A6E172D04
After mixColumns:
06EFCB6D3FD8ADB89E7EBC0ECC332F80
After addRoundKey(7):
90654AAC7E245AE8A20FC6342734232B
After subBytes:
604DD691F336BE9B3A76B418CC1826F1
After shiftRows:
6036B4F1F37626913A18D69BCC4DBE18
After mixColumns:
DF3A2DDBD0E4616711F023ADF297CE8C
After addRoundKey(8):
4190A2F310150C22E036C04A3F69AC65
After subBytes:
83603A0DCA59FE93E105BAD675F9914D
After shiftRows:
8359BA4DCA05910DE1F93A937560FED6
After mixColumns:
01A962E71C65E1CB60D5C2C6627A93B6
After addRoundKey(9):
2A98493876A83D4436696473DFC139A8
After subBytes:
E5463B0738C2271B05F9438F9E7812C2
After shiftRows:
E5C243C238F9120705783B1B9E46278F
After mixColumns:
0D7DFC2A75E0ECADA2A3267A45F41CDD
After addRoundKey(10):
697B0178D1177CBAF792558ADD3B0DC4
After subBytes:
F9217CBC3EF010F4684FFC7EC1E2D71C
After shiftRows:
F9F0FC1C3E4FD7BC68E27CF4C121107E
After mixColumns:
0201CE24C67E1BB965C775D594CD4295
After addRoundKey(11):
6FBA672FC1086E3D340DA6E478BC3BBA
After subBytes:
A8F4851578309F2718D72469BC65E2F4
After shiftRows:
A83024F478D7E21518658527BCF49F69
After mixColumns:
CB50D70465E54F973D610586929CD666
After addRoundKey(12):
2CE03F9826A2371C2B170EFD1C25CC04
After subBytes:
71E17546F73A9A9CF1F0AB549C3F4BF2
After shiftRows:
713AABF2F7F04B46F13F759C9CE19A54
After mixColumns:
F5110BFDF3975B35518C9B61D5A4AE6C
After addRoundKey(13):
81FC005C800C251073DD36751B847A57
After subBytes:
0CB0634ACDFE3FCA8FC1059DAF5FDA5B
After shiftRows:
0CFE055BCDC1DA4A8F5F63CAAFB03F9D
After addRoundKey(14):
1C060F4C9E7EA8D6CA961A2D64C05C18
The ciphertext:
1C 9E CA 64 
06 7E 96 C0 
0F A8 1A 5C 
4C D6 2D 18
   
[Input of test 2]
[command line]
java AES e key plaintext2

plaintext 2
337392BFA82564EF25A67E85D928C072

[Output of test 2]
The Plaintext is:
33 A8 25 D9 
73 25 A6 28 
92 64 7E C0 
BF EF 85 72 

The CipherKey is:
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 

The expanded key is:

2323232323232323
6363636363636363
6363636363636363
6363636363636363

9898989898989898
9898989898989898
9898989898989898
4545454545454545

9E9E9E9E9E9E9E9E
DEDEDEDEDEDEDEDE
F6F6F6F6F6F6F6F6
0303030303030303

C3C3C3C3C3C3C3C3
9C9C9C9C9C9C9C9C
8D8D8D8D8D8D8D8D
0808080808080808

5D5D5D5D5D5D5D5D
C1C1C1C1C1C1C1C1
BDBDBDBDBDBDBDBD
2626262626262626

6565656565656565
BBBBBBBBBBBBBBBB
4A4A4A4A4A4A4A4A
6A6A6A6A6A6A6A6A

CFCFCFCFCFCFCFCF
6D6D6D6D6D6D6D6D
4848484848484848
2727272727272727

B3B3B3B3B3B3B3B3
3F3F3F3F3F3F3F3F
8484848484848484
ADADADADADADADAD

8686868686868686
6060606060606060
1111111111111111
C0C0C0C0C0C0C0C0

1616161616161616
E2E2E2E2E2E2E2E2
ABABABABABABABAB
8484848484848484

CECECECECECECECE
8080808080808080
F4F4F4F4F4F4F4F4
C3C3C3C3C3C3C3C3

4343434343434343
3F3F3F3F3F3F3F3F
DADADADADADADADA
4848484848484848

1616161616161616
E2E2E2E2E2E2E2E2
ABABABABABABABAB
8484848484848484

CECECECECECECECE
8080808080808080
F4F4F4F4F4F4F4F4
C3C3C3C3C3C3C3C3

After AddRoundKey(0):
33 73 92 BF A8 25 64 EF 25 A6 7E 85 D9 28 C0 72 
After subBytes:
C3 8F 4F 08 C2 3F 43 DF 3F 24 F3 97 35 34 BA 40 
After shiftRows:
C3 3F F3 40 C2 24 BA 08 3F 34 4F DF 35 8F 43 97 
After mixColumns:
6F F3 C1 12 41 57 91 D3 B2 59 EF 9F 34 62 9E A6 
After AddRoundKey(1):
4C 22 D1 57 D0 34 3A 01 E2 F2 8C FD 31 B0 FC C5 
After subBytes:
29 93 3E 5B 70 18 80 7C 98 89 64 54 C7 E7 B0 A6 
After shiftRows:
29 18 64 A6 70 89 B0 5B 98 E7 3E 7C C7 93 80 54 
After AddRoundKey(14):
E7 F0 6C 04 D6 09 13 50 AA 30 CA 43 68 DB 88 97 
After subBytes:
94 8C 50 F2 F6 01 7D 53 AC 04 74 1A 45 B9 C4 88 
After shiftRows:
94 01 74 88 F6 04 C4 F2 AC B9 50 53 45 8C 7D 1A 
After mixColumns:
CC 82 FE D9 CD 5B 6C 3E 90 66 40 A0 62 DB 1D 0A 
After AddRoundKey(2):
54 55 08 27 1A C3 FE 9E 66 F4 D8 58 41 A6 38 4F 
After subBytes:
20 FC 30 CC A2 2E BB 0B 33 BF 61 6A 83 24 07 84 
After shiftRows:
20 2E 61 84 A2 BF 07 CC 33 24 30 0B 83 FC BB 6A 
After AddRoundKey(14):
EE 22 C7 40 E0 3F D0 3F AF 87 C4 78 4A 4C FF A9 
After subBytes:
28 93 C6 09 E1 75 70 75 79 17 1C BC D6 29 16 D3 
After shiftRows:
28 75 1C D3 E1 17 16 09 79 29 C6 75 D6 93 70 BC 
After mixColumns:
00 35 0B AC FF FC C1 2B 3A 0F 58 8E D5 C7 7A E1 
After AddRoundKey(3):
9E 21 CC D6 AB 22 F9 C4 95 1F AE 79 32 F5 78 E2 
After subBytes:
0B FD 4B F6 62 93 99 1C 2A C0 E4 B6 23 E6 BC 98 
After shiftRows:
0B 93 E4 98 62 C0 BC F6 2A E6 4B 1C 23 FD 99 B6 
After AddRoundKey(14):
C5 E2 DE E0 5D 40 12 3E 2A 3C BF 5A 56 76 E8 75 
After subBytes:
A6 98 1D E1 4C 09 C9 B2 E5 EB 08 BE B1 38 9B 9D 
After shiftRows:
A6 09 08 9D 4C EB 9B E1 E5 38 1D B2 B1 98 C9 BE 
After mixColumns:
D9 31 03 D1 C4 D6 B2 7D 36 00 2A 6E BD 64 79 FE 
After AddRoundKey(4):
1A 58 BB B5 F2 4A 8D 6C C0 2E A7 71 12 E1 E3 F6 
After subBytes:
A2 6A EA D5 89 D6 5D 50 BA 31 5C A3 C9 F8 11 42 
After shiftRows:
A2 D6 5C 42 89 31 11 D5 BA F8 EA 50 C9 6A 5D A3 
After AddRoundKey(14):
6C 09 4E 0A 18 B1 0C A9 92 91 1E 9E 8C 55 A4 60 
After subBytes:
50 01 2F 67 AD C8 FE D3 4F 81 72 0B 64 FC 49 D0 
After shiftRows:
50 C8 72 D0 AD 81 49 67 4F FC 2F D3 64 01 FE 0B 
After mixColumns:
41 9D 17 F1 F7 08 17 EA 7D 0E 83 BF 3E 74 9F 45 
After AddRoundKey(5):
1C 36 C0 18 C0 C9 B3 52 4A D6 3E B9 AC 2B 02 63 
After subBytes:
9C 05 BA AD BA DD 6D 00 D6 F6 B2 56 91 F1 77 FB 
After shiftRows:
9C DD B2 FB BA F6 77 AD D6 F1 BA 00 91 05 6D 56 
After AddRoundKey(14):
52 3A 22 52 13 76 05 C6 7C F7 4E AE 35 2D F4 95 
After subBytes:
00 80 93 00 7D 38 6B B4 10 68 2F E4 96 D8 BF 2A 
After shiftRows:
00 38 2F 2A 7D 68 BF 00 10 D8 93 B4 96 80 6B E4 
After mixColumns:
4D 2B 18 43 FD 77 70 50 74 A1 32 08 23 D4 F7 99 
After AddRoundKey(6):
28 46 3E 49 4E CC EB BE 7D CB 78 9D 26 EB 42 F3 
After subBytes:
34 5A B2 3B 2F 4B E9 AE FF 1F BC 5E F7 E9 2C 0D 
After shiftRows:
34 4B BC 0D 2F 1F 2C 3B FF E9 B2 AE F7 5A E9 5E 
After AddRoundKey(14):
FA AF 0B 34 85 9F 1D 99 72 AC 46 2A C3 BB 5A 9D 
After subBytes:
2D 79 2B 18 97 DB A4 EE 40 91 5A E5 2E EA BE 5E 
After shiftRows:
2D DB 5A 5E 97 91 BE 18 40 EA 2B EE 2E 79 A4 E5 
After mixColumns:
28 30 A0 4A 3B 6F 49 BD 60 1C D5 C6 96 CE 30 7E 
After AddRoundKey(7):
E7 56 28 B1 FF 02 54 E9 6F 24 9D 17 85 D0 8E 59 
After subBytes:
94 B1 34 C8 16 77 20 1E A8 36 5E F0 97 70 19 CB 
After shiftRows:
94 77 5E CB 16 36 19 C8 A8 70 34 1E 97 B1 20 F0 
After AddRoundKey(14):
5A 96 5C 54 B9 B6 84 72 90 99 C0 E3 05 48 EA 33 
After subBytes:
BE 90 4A 20 56 4E 5F 40 60 EE BA 11 6B 52 87 C3 
After shiftRows:
BE 4E BA C3 56 EE 87 20 60 52 4A 40 6B 90 5F 11 
After mixColumns:
CC 34 C1 B0 22 23 CD D3 3C 5A 66 38 33 A0 76 50 
After AddRoundKey(8):
7F 1D B8 9E 87 1C DE 0D 72 F2 E2 DB 03 EC BC FD 
After subBytes:
D2 A4 6C 0B 17 9C 1D D7 40 89 98 B9 7B CE 65 54 
After shiftRows:
D2 9C 98 54 17 89 65 0B 40 CE 6C D7 7B A4 1D B9 
After AddRoundKey(14):
1C 97 B4 B8 52 09 3A 67 56 E5 98 DE 9A 8B 23 7A 
After subBytes:
9C 88 8D 6C 00 01 80 85 B1 D9 46 1D B8 3D 26 DA 
After shiftRows:
9C 01 46 DA 00 D9 26 6C B1 3D 8D 85 B8 88 80 1D 
After mixColumns:
BC 8E 64 57 3A AF 21 27 36 C2 19 69 75 35 0C E1 
After AddRoundKey(9):
3A 5A 27 B5 08 CF D3 F5 E2 41 08 CC D1 47 78 21 
After subBytes:
80 BE CC D5 30 8A 66 E6 98 83 30 4B 3E A0 BC FD 
After shiftRows:
80 8A 30 FD 30 83 BC D5 98 A0 CC E6 3E BE 66 4B 
After AddRoundKey(14):
4E B0 6C FD 44 03 54 7D FE 3C 38 A5 33 55 12 88 
After subBytes:
2F E7 50 54 1B 7B 20 FF BB EB 07 06 C3 FC C9 C4 
After shiftRows:
2F 7B 07 C4 1B EB C9 54 BB FC 50 FF C3 E7 20 06 
After mixColumns:
10 14 0D 9E 8D C2 85 A7 DD 57 FD 9F 89 70 6E 95 
After AddRoundKey(10):
06 6F 76 0D 02 20 FC F4 1B 67 56 EA 88 45 34 11 
After subBytes:
6F A8 38 D7 77 B7 B0 BF AF 85 B1 87 C4 6E 18 82 
After shiftRows:
6F B7 B1 82 77 85 18 D7 AF 6E 38 BF C4 A8 B0 87 
After AddRoundKey(14):
A1 F7 5B 07 79 05 9A 6B 7F 98 CC 73 4C 57 4B 44 
After subBytes:
32 68 39 C5 B6 6B B8 7F D2 46 4B 8F 29 5B B3 1B 
After shiftRows:
32 6B 4B 1B B6 46 B3 C5 D2 5B 39 7F 29 68 B8 8F 
After mixColumns:
89 22 E2 40 CB 31 D9 A5 14 50 7A F1 DD A5 A0 AE 
After AddRoundKey(11):
47 4B E0 1E EC B1 A4 66 2C 59 8E 63 8E 25 05 6D 
After subBytes:
A0 B3 E1 72 CE C8 49 33 71 CB 19 FB 19 3F 6B 3C 
After shiftRows:
A0 C8 19 3C CE CB 6B 72 71 3F E1 33 19 B3 49 FB 
After AddRoundKey(14):
6E 4E 85 DA 06 4B CB 70 D7 EB 15 8A F2 F2 C7 38 
After subBytes:
9F 2F 97 57 6F B3 1F 51 0E E9 59 7E 89 89 C6 07 
After shiftRows:
9F B3 59 07 6F E9 C6 57 0E 89 97 51 89 2F 1F 7E 
After mixColumns:
B5 0E 97 5E 6F A0 E8 30 5A F4 41 AE 19 88 1A 4C 
After AddRoundKey(12):
F6 50 80 51 4D 9F 2E C0 D4 D7 9B 52 1D 0F 74 04 
After subBytes:
42 53 CD D1 E3 DB 31 BA 48 0E 14 00 A4 76 92 F2 
After shiftRows:
42 DB 14 F2 E3 0E 92 D1 48 76 CD BA A4 53 31 00 
After AddRoundKey(14):
8C 63 BC 67 15 8E 82 90 DA 12 39 F2 3C 51 4E C3 
After subBytes:
64 FB 65 85 59 19 13 60 57 C9 12 89 EB D1 2F 2E 
After shiftRows:
64 19 12 2E 59 C9 2F 85 57 D1 65 60 EB FB 13 89 
After mixColumns:
DF 4E 2B FB 58 24 5A 1C C3 21 EC 8D 41 BA B6 C7 
After AddRoundKey(13):
C9 BA 68 C5 58 C6 8A 3E 3D B8 47 32 ED FE 26 43 
After subBytes:
DD F4 45 A6 6A B4 7E B2 27 6C A0 23 55 BB F7 1A 
After shiftRows:
DD B4 A0 1A 6A 6C F7 A6 27 BB 45 B2 55 F4 7E 23 
After AddRoundKey(14):
13 EA D3 96 7A EC 4F 37 6E 77 B1 BD D4 26 46 E0 

[Input of test 3]
java AES e key plaintext3

plaintext3
76432F3957B78352A764DC086B325A32
Key
93264AD6534F14861E92164C216B6A0973D384E8936D38946B328C07A0973241

[Output of test 3]
The Plaintext is:
76 57 A7 6B 
43 B7 64 32 
2F 83 DC 5A 
39 52 08 32 

The CipherKey is:
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 

The expanded key is:

2323232323232323
6363636363636363
6363636363636363
6363636363636363

9898989898989898
9898989898989898
9898989898989898
4545454545454545

9E9E9E9E9E9E9E9E
DEDEDEDEDEDEDEDE
F6F6F6F6F6F6F6F6
0303030303030303

C3C3C3C3C3C3C3C3
9C9C9C9C9C9C9C9C
8D8D8D8D8D8D8D8D
0808080808080808

5D5D5D5D5D5D5D5D
C1C1C1C1C1C1C1C1
BDBDBDBDBDBDBDBD
2626262626262626

6565656565656565
BBBBBBBBBBBBBBBB
4A4A4A4A4A4A4A4A
6A6A6A6A6A6A6A6A

CFCFCFCFCFCFCFCF
6D6D6D6D6D6D6D6D
4848484848484848
2727272727272727

B3B3B3B3B3B3B3B3
3F3F3F3F3F3F3F3F
8484848484848484
ADADADADADADADAD

8686868686868686
6060606060606060
1111111111111111
C0C0C0C0C0C0C0C0

1616161616161616
E2E2E2E2E2E2E2E2
ABABABABABABABAB
8484848484848484

CECECECECECECECE
8080808080808080
F4F4F4F4F4F4F4F4
C3C3C3C3C3C3C3C3

4343434343434343
3F3F3F3F3F3F3F3F
DADADADADADADADA
4848484848484848

1616161616161616
E2E2E2E2E2E2E2E2
ABABABABABABABAB
8484848484848484

CECECECECECECECE
8080808080808080
F4F4F4F4F4F4F4F4
C3C3C3C3C3C3C3C3

After AddRoundKey(0):
76 43 2F 39 57 B7 83 52 A7 64 DC 08 6B 32 5A 32 
After subBytes:
38 1A 15 12 5B A9 EC 00 5C 43 86 30 7F 23 BE 23 
After shiftRows:
38 A9 86 23 5B 43 BE 12 5C 23 15 00 7F 1A EC 30 
After mixColumns:
35 C3 E3 21 DF 16 49 34 C8 25 55 D2 0C 54 F6 17 
After AddRoundKey(1):
16 BC AB 6F E0 75 46 37 C0 2A 36 95 02 57 B1 74 
After subBytes:
47 65 62 A8 E1 9D 5A 9A BA E5 05 2A 77 5B C8 92 
After shiftRows:
47 9D 05 92 E1 E5 C8 A8 BA 5B 62 9A 77 65 5A 2A 
After AddRoundKey(14):
89 61 4E B4 53 65 AF A6 CB 48 96 99 5C 28 6E E9 
After subBytes:
A7 EF 2F 8D ED 4D 79 24 1F 52 90 EE 4A 34 9F 1E 
After shiftRows:
A7 4D 90 1E ED 52 9F 8D 1F 34 2F 24 4A EF 79 EE 
After mixColumns:
0C 88 F3 13 25 7E 16 E0 69 22 19 72 29 EA 7E 8F 
After AddRoundKey(2):
94 BD F1 6C 10 E6 BA AF 6B 8E 81 3B 8B 78 EA CA 
After subBytes:
22 7A A1 50 CA 8E F4 79 7F 19 0C E2 3D BC 87 74 
After shiftRows:
22 8E 0C 74 CA 19 87 50 7F BC A1 79 3D 7A F4 E2 
After AddRoundKey(14):
EC 4A 8B FE 40 99 48 B9 C2 07 55 37 BA D0 8D 21 
After subBytes:
CE D6 3D BB 09 EE 52 56 25 C5 FC 9A F4 70 5D FD 
After shiftRows:
CE EE FC FD 09 C5 5D BB 25 70 3D 56 F4 D6 52 9A 
After mixColumns:
AF EB DF BA A0 C4 A0 EE B1 D4 D5 8E 5A 2F 33 AC 
After AddRoundKey(3):
31 7E 47 59 75 1A 22 2C 41 7E 23 30 24 30 78 AF 
After subBytes:
C7 F3 A0 CB 9D A2 93 71 83 F3 26 04 36 04 BC 79 
After shiftRows:
C7 A2 26 79 9D F3 BC CB 83 04 A0 71 36 F3 93 04 
After AddRoundKey(14):
09 1D 77 F5 6C 73 F0 30 E8 3C 54 50 B7 4B 85 C7 
After subBytes:
01 A4 F5 E6 50 8F 8C 04 9B EB 20 53 A9 B3 97 C6 
After shiftRows:
01 8F 20 C6 50 EB 97 E6 9B B3 F5 04 A9 A4 8C 53 
After mixColumns:
6E A2 9F 3B F7 D9 BF 5B 12 E6 D5 F8 61 26 FB 6E 
After AddRoundKey(4):
AD 6B 9F 69 61 45 6B 2E 5C 23 58 F3 F8 C7 75 66 
After subBytes:
95 7F DB F9 EF 6E 7F 31 4A 26 6A 0D 41 C6 9D 33 
After shiftRows:
95 6E 6A 33 EF 26 9D F9 4A C6 DB 31 41 7F 7F 0D 
After AddRoundKey(14):
5B 6F BE 82 A0 A6 32 BC A4 1D 2F BC FD 79 C5 CE 
After subBytes:
39 A8 AE 13 E0 24 23 65 49 A4 15 65 54 B6 A6 8B 
After shiftRows:
39 24 15 8B E0 A4 A6 13 49 B6 AE 65 54 A8 23 65 
After mixColumns:
80 C5 B1 77 99 51 26 1F 98 B2 17 09 0D 1F 15 BD 
After AddRoundKey(5):
DD 58 25 2B 98 90 0F 39 EC E7 AA 33 2A DE B4 9B 
After subBytes:
C1 6A 3F F1 46 60 76 12 CE 94 AC C3 E5 1D 8D 14 
After shiftRows:
C1 60 AC 14 46 94 8D F1 CE 1D 3F 12 E5 6A 76 C3 
After AddRoundKey(14):
0F C6 3A 26 AE 14 E9 A9 62 0D CB B5 DA 71 E6 00 
After subBytes:
76 B4 80 F7 E4 FA 1E D3 AA D7 1F D5 57 A3 8E 63 
After shiftRows:
76 FA 1F 63 E4 D7 8E F7 AA A3 80 D3 57 B4 1E D5 
After mixColumns:
85 DB 17 B9 C8 2F 36 9B E2 BF 7C 7B A2 D3 BB E2 
After AddRoundKey(6):
E0 73 A8 C8 BE 94 F5 B9 72 8D 36 D1 DC 20 31 88 
After subBytes:
E1 8F C2 E8 AE 22 E6 56 40 5D 05 3E 86 B7 C7 C4 
After shiftRows:
E1 22 05 C4 AE 5D C7 E8 40 B7 C2 56 86 8F E6 3E 
After AddRoundKey(14):
2F 2E B4 45 EC DD 43 4C CB 47 36 25 0A 68 A2 FD 
After subBytes:
15 31 8D 6E CE C1 1A 29 1F A0 05 3F 67 45 3A 54 
After shiftRows:
15 C1 05 54 CE A0 3A 6E 1F 45 8D 29 67 31 1A 3F 
After mixColumns:
23 D7 22 53 28 B5 A8 0F 55 30 20 BB B8 14 23 FC 
After AddRoundKey(7):
EC 45 1D 9F 18 D8 78 33 ED C5 68 04 9C 62 F3 DB 
After subBytes:
CE 6E A4 DB AD 61 BC C3 55 A6 45 F2 DE AA 0D B9 
After shiftRows:
CE 61 45 B9 AD A6 0D DB 55 AA A4 C3 DE 6E BC F2 
After AddRoundKey(14):
00 2D A1 1D AF 26 5E AD 8B 8D 50 7F 77 5B 37 31 
After subBytes:
63 D8 32 A4 79 F7 58 95 3D 5D 53 D2 F5 39 9A C7 
After shiftRows:
63 F7 53 C7 79 5D 9A A4 3D 39 32 95 F5 D8 58 D2 
After mixColumns:
50 A4 60 94 2B D2 FC 1F 96 8C C4 7D 08 64 F0 3B 
After AddRoundKey(8):
E3 14 12 A5 17 ED 08 C9 D3 C3 40 5D 27 20 F9 96 
After subBytes:
11 FA C9 06 F0 55 30 DD 66 2E 09 4C CC B7 99 90 
After shiftRows:
11 55 09 90 F0 2E 99 06 66 B7 C9 DD CC FA 30 4C 
After AddRoundKey(14):
DF 70 92 0F 9B AE 43 39 C7 19 3D F3 5E 86 29 8F 
After subBytes:
9E 51 4F 76 14 E4 1A 12 C6 D4 27 0D 58 44 A5 73 
After shiftRows:
9E E4 27 73 14 D4 A5 76 C6 44 4F 12 58 51 1A 0D 
After mixColumns:
44 57 A1 9C 9C 25 0B A1 06 8D 2A 7E 54 D9 2A B9 
After AddRoundKey(9):
C2 FC 17 94 D1 45 9C 19 27 6B 3B EA 1A C1 6F 79 
After subBytes:
25 B0 F0 22 3E 6E DE D4 CC 7F E2 87 A2 78 A8 B6 
After shiftRows:
25 6E E2 B6 3E 7F A8 22 CC 78 F0 D4 A2 B0 DE 87 
After AddRoundKey(14):
EB BE 38 61 A0 FF 8C 73 2C 28 04 1D 78 A2 20 44 
After subBytes:
E9 AE 07 EF E0 16 64 8F 71 34 F2 A4 BC 3A B7 1B 
After shiftRows:
E9 16 F2 1B E0 34 B7 EF 71 3A 07 8F BC AE 64 A4 
After mixColumns:
1A D3 2D F2 DF A5 8B 7D 24 83 CF AB 4A F3 2D 46 
After AddRoundKey(10):
0C 3D 8F CE C5 47 28 77 3B 69 64 A9 E4 9F 00 C2 
After subBytes:
FE 27 73 8B A6 A0 34 F5 E2 F9 43 D3 69 DB 63 25 
After shiftRows:
FE A0 43 25 A6 F9 63 8B E2 DB 73 F5 69 27 34 D3 
After AddRoundKey(14):
30 26 16 AA 6E 79 2F E4 8D E3 87 F7 EB 0B 01 10 
After subBytes:
04 F7 47 AC 9F B6 15 69 5D 11 17 68 E9 2B 7C CA 
After shiftRows:
04 B6 17 CA 9F 11 7C AC 5D 2B 47 69 E9 F7 15 68 
After mixColumns:
14 80 D9 22 C6 95 99 94 E9 AB 43 59 B6 4B 8C 12 
After AddRoundKey(11):
DA 46 1D 75 4E 15 5F 88 17 19 B7 4F EC 14 AD D1 
After subBytes:
57 5A A4 9D 2F 59 CF C4 F0 D4 A9 84 CE FA 95 3E 
After shiftRows:
57 59 A9 3E 2F D4 95 9D F0 FA A4 C4 CE 5A CF 84 
After AddRoundKey(14):
99 AF 04 0D 97 54 0E 99 67 15 50 0C F0 1D 30 47 
After subBytes:
EE 79 F2 D7 88 20 AB EE 85 59 53 FE 8C A4 04 A0 
After shiftRows:
EE 20 53 A0 88 59 04 D7 85 A4 F2 EE 8C 79 AB FE 
After mixColumns:
54 FB 93 01 33 E1 BB 6B FA 35 F7 05 DD 66 A1 BA 
After AddRoundKey(12):
17 0C 20 95 B8 DE EF 2E D0 84 2D E9 42 54 DF F2 
After subBytes:
F0 FE B7 2A 6C 1D DF 31 70 5F D8 1E 2C 20 9E 89 
After shiftRows:
F0 1D D8 89 6C 5F 9E 2A 70 20 B7 31 2C FE DF 1E 
After AddRoundKey(14):
3E EC 84 EF D3 DF D4 3D 16 1E 43 1C 47 AA C5 DD 
After subBytes:
B2 CE 5F DF 66 9E 48 27 47 72 1A 9C A0 AC A6 C1 
After shiftRows:
B2 9E 1A C1 66 72 A6 DF 47 AC 5F 27 A0 CE 48 9C 
After mixColumns:
1D 7A 40 D0 23 AC 39 DB 19 C2 3C 74 C6 63 41 5E 
After AddRoundKey(13):
0B C1 B2 42 6C 4E 69 E7 56 DB 97 C5 C6 39 DF DA 
After subBytes:
2B 78 37 2C 50 2F F9 94 B1 B9 88 A6 B4 12 9E 57 
After shiftRows:
2B 2F 88 57 50 B9 9E 2C B1 12 37 94 B4 78 F9 A6 
After AddRoundKey(14):
E5 D0 45 77 E1 39 E6 BB 46 1E C3 3A 99 AC 60 65 

[Input of test 4]
java AES e key plaintext4

plaintext4
8256236532AD73564FE87634B93246C3

kEY
0000000000000000000000000000000000000000000000000000000000000000

[Output of test 4]
The Plaintext is:
82 32 4F B9 
56 AD E8 32 
23 73 76 46 
65 56 34 C3 

The CipherKey is:
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 

The expanded key is:

2323232323232323
6363636363636363
6363636363636363
6363636363636363

9898989898989898
9898989898989898
9898989898989898
4545454545454545

9E9E9E9E9E9E9E9E
DEDEDEDEDEDEDEDE
F6F6F6F6F6F6F6F6
0303030303030303

C3C3C3C3C3C3C3C3
9C9C9C9C9C9C9C9C
8D8D8D8D8D8D8D8D
0808080808080808

5D5D5D5D5D5D5D5D
C1C1C1C1C1C1C1C1
BDBDBDBDBDBDBDBD
2626262626262626

6565656565656565
BBBBBBBBBBBBBBBB
4A4A4A4A4A4A4A4A
6A6A6A6A6A6A6A6A

CFCFCFCFCFCFCFCF
6D6D6D6D6D6D6D6D
4848484848484848
2727272727272727

B3B3B3B3B3B3B3B3
3F3F3F3F3F3F3F3F
8484848484848484
ADADADADADADADAD

8686868686868686
6060606060606060
1111111111111111
C0C0C0C0C0C0C0C0

1616161616161616
E2E2E2E2E2E2E2E2
ABABABABABABABAB
8484848484848484

CECECECECECECECE
8080808080808080
F4F4F4F4F4F4F4F4
C3C3C3C3C3C3C3C3

4343434343434343
3F3F3F3F3F3F3F3F
DADADADADADADADA
4848484848484848

1616161616161616
E2E2E2E2E2E2E2E2
ABABABABABABABAB
8484848484848484

CECECECECECECECE
8080808080808080
F4F4F4F4F4F4F4F4
C3C3C3C3C3C3C3C3

After AddRoundKey(0):
82 56 23 65 32 AD 73 56 4F E8 76 34 B9 32 46 C3 
After subBytes:
13 B1 26 4D 23 95 8F B1 84 9B 38 18 56 23 5A 2E 
After shiftRows:
13 95 38 2E 23 9B 5A 4D 84 23 26 B1 56 B1 8F 18 
After mixColumns:
94 44 84 C4 E7 AD DB 3E E1 19 23 EB F3 BD CA F4 
After AddRoundKey(1):
B7 84 82 90 67 CE 7A DE A7 B8 40 A9 E7 5D 88 97 
After subBytes:
A9 5F 13 60 85 8B DA 1D 5C 6C 09 D3 94 4C C4 88 
After shiftRows:
A9 8B 09 88 85 6C C4 60 5C 4C 13 1D 94 5F DA D3 
After AddRoundKey(14):
67 05 A8 57 45 EC B8 9C C7 44 E7 19 46 E0 E9 10 
After subBytes:
85 6B C2 5B 6E CE 6C DE C6 1B 94 D4 5A E1 1E CA 
After shiftRows:
85 CE 94 CA 6E 1B 1E 5B C6 E1 C2 DE 5A 6B 6C D4 
After mixColumns:
06 6F 3D 41 B4 21 A4 01 B3 9C C1 D5 B1 EC 8E 5A 
After AddRoundKey(2):
9E 2C 2B F4 F7 B9 04 A9 A5 3C 59 CB D9 99 4D 1F 
After subBytes:
0B 71 F1 BF 68 56 F2 D3 06 EB CB 1F 35 EE E3 C0 
After shiftRows:
0B 56 CB C0 68 EB E3 BF 06 EE F1 D3 35 71 F2 1F 
After AddRoundKey(14):
C5 E8 F2 F6 98 6B 1A B2 05 63 05 31 0E 3F 27 DC 
After subBytes:
A6 9B 89 42 46 7F A2 37 6B FB 6B C7 AB 75 CC 86 
After shiftRows:
A6 7F 6B 86 46 FB CC 42 6B 75 89 37 AB 9B A2 C7 
After mixColumns:
3B 63 9E F2 14 A6 F8 79 F7 36 4E 2F 9E BC 3D 4A 
After AddRoundKey(3):
A5 CA 01 9D FD 78 C0 BF 00 26 B8 3E 6C A7 D9 49 
After subBytes:
06 74 7C 5E 54 BC BA 08 63 F7 6C B2 50 5C 35 3B 
After shiftRows:
06 BC 6C 3B 54 F7 35 5E 63 5C 7C 08 50 74 BA B2 
After AddRoundKey(14):
C8 D4 97 93 72 77 A8 B7 A2 B5 88 79 F5 DE FC 71 
After subBytes:
E8 48 88 DC 40 F5 C2 A9 3A D5 C4 B6 E6 1D B0 A3 
After shiftRows:
E8 F5 C4 A3 40 D5 B0 DC 3A 1D 88 A9 E6 48 C2 B6 
After mixColumns:
A8 ED 70 4F 88 E6 91 06 72 2A CC 92 7B 9D F0 CC 
After AddRoundKey(4):
6B 14 FF 73 2E 7A A7 95 B3 0D 41 F8 8C 9A 1F C4 
After subBytes:
7F FA 16 8F 31 DA 5C 2A 6D D7 83 41 64 B8 C0 1C 
After shiftRows:
7F DA 83 1C 31 D7 C0 8F 6D B8 16 2A 64 FA 5C 41 
After AddRoundKey(14):
B1 B1 99 A7 14 57 4C 39 4D 40 E2 9F D2 0F DE 82 
After subBytes:
C8 C8 EE 5C FA 5B 29 12 E3 09 98 DB B5 76 1D 13 
After shiftRows:
C8 5B 98 13 FA 09 1D 5C E3 76 EE 12 B5 C8 29 DB 
After mixColumns:
ED DE 8D A6 B5 93 2D B9 BB 34 64 82 C0 9E 59 88 
After AddRoundKey(5):
B0 74 06 E6 83 52 89 B8 D0 EC D9 7F FB 78 3F AE 
After subBytes:
E7 92 6F 8E EC 00 A7 6C 70 CE 35 D2 0F BC 75 E4 
After shiftRows:
E7 00 35 E4 EC CE 75 8E 70 BC 6F 6C 0F 92 A7 D2 
After AddRoundKey(14):
29 6C 84 CC CE 4E 48 51 FB F5 9B 64 2A 0E 98 11 
After subBytes:
A5 50 5F 4B 8B 2F 52 D1 0F E6 14 43 E5 AB 46 82 
After shiftRows:
A5 2F 14 82 8B E6 46 4B 0F AB 5F D1 E5 50 52 43 
After mixColumns:
B6 45 3F D0 31 DD 3C B0 76 72 72 5C 30 F0 D4 B0 
After AddRoundKey(6):
D3 8A 3C 5A 20 66 38 9A 5A 87 38 BE B5 0B 16 DA 
After subBytes:
66 7E EB BE B7 33 07 B8 BE 17 07 AE D5 2B 47 57 
After shiftRows:
66 33 07 57 B7 17 47 BE BE 2B EB B8 D5 7E 07 AE 
After AddRoundKey(14):
A8 37 4A 16 FD 97 DF BD C9 C7 1F C4 99 3E 4C 6D 
After subBytes:
C2 9A D6 47 54 88 9E 7A DD C6 C0 1C EE B2 29 3C 
After shiftRows:
C2 88 C0 3C 54 C6 29 47 DD B2 D6 7A EE 9A 9E 1C 
After mixColumns:
E0 AE 95 6D 97 FF 09 9D C0 B9 56 EC F0 64 77 15 
After AddRoundKey(7):
2F FA 88 D7 61 92 F1 43 5A 64 1E 50 A2 F0 A4 32 
After subBytes:
15 2D C4 0E EF 4F A1 1A BE 43 72 53 3A 8C 49 23 
After shiftRows:
15 4F 72 23 EF 43 49 0E BE 8C C4 1A 3A 2D A1 53 
After AddRoundKey(14):
DB 6F 4A F9 81 C3 78 EE BC C9 30 62 ED 8E EE 90 
After subBytes:
B9 A8 D6 99 0C 2E BC 28 65 DD 04 AA 55 19 28 60 
After shiftRows:
B9 2E 04 60 0C DD 28 99 65 19 D6 28 55 A8 BC AA 
After mixColumns:
7F 89 3F 3A D5 4C 31 C8 1F 1E B3 30 5F 6B 7B A4 
After AddRoundKey(8):
CC EA 9B F2 3A 73 9A C6 8C 0E 37 D6 89 F7 B4 09 
After subBytes:
4B 87 14 89 80 8F B8 B4 64 AB 9A F6 A7 68 8D 01 
After shiftRows:
4B 8F 9A 01 80 AB 8D 89 64 68 14 B4 A7 87 B8 F6 
After AddRoundKey(14):
85 00 90 64 41 2B 9C 44 54 0D E0 7B CF 09 40 35 
After subBytes:
97 63 60 43 83 F1 DE 1B 20 D7 E1 21 8A 01 09 96 
After shiftRows:
97 F1 E1 96 83 D7 09 43 20 01 60 1B 8A 63 DE 21 
After mixColumns:
4A C0 1E 85 35 6E 83 C6 38 99 CC 37 55 14 2D 7A 
After AddRoundKey(9):
CC 55 29 95 46 0E 88 D4 98 E3 DD ED 03 A6 26 BA 
After subBytes:
4B FC A5 2A 5A AB C4 48 46 11 C1 55 7B 24 F7 F4 
After shiftRows:
4B AB C1 F4 5A 11 F7 2A 46 24 A5 48 7B FC C4 55 
After AddRoundKey(14):
85 DA B2 B8 65 91 D0 3F 0F 77 51 07 3A AA BC 96 
After subBytes:
97 57 37 6C 4D 81 70 75 76 F5 D1 C5 80 AC 65 90 
After shiftRows:
97 81 D1 90 4D F5 65 6C 76 AC 37 75 80 57 70 C5 
After mixColumns:
EC 76 04 C9 97 7F C6 9F 41 19 2B EB 57 7B 63 2D 
After AddRoundKey(10):
FA 75 EA D3 60 9D B2 FF 12 24 80 E7 DF 7D 40 A9 
After subBytes:
2D 9D 87 66 D0 5E 37 16 C9 36 CD 94 9E FF 09 D3 
After shiftRows:
2D 5E CD D3 D0 36 09 66 C9 FF 87 16 9E 9D 37 94 
After AddRoundKey(14):
E3 50 3D 5D 90 B6 0B 5E 03 89 73 F4 1D E6 E2 57 
After subBytes:
11 53 27 4C 60 4E 2B 58 7B A7 8F BF A4 8E 98 5B 
After shiftRows:
11 4E 8F 5B 60 A7 98 4C 7B 8E 27 58 A4 53 2B BF 
After mixColumns:
24 5C B7 44 E6 CA 38 07 00 4D 53 94 32 C0 7B EA 
After AddRoundKey(11):
EA 66 F4 F1 92 4A B9 03 79 B8 A7 B8 8A 87 60 29 
After subBytes:
87 33 BF A1 4F D6 56 7B B6 6C 5C 6C 7E 17 D0 A5 
After shiftRows:
87 D6 5C A5 4F 6C D0 A1 B6 17 BF 7B 7E 33 56 6C 
After AddRoundKey(14):
49 CF 42 BD 18 EC E3 F0 92 50 4B 95 6B 21 8F AF 
After subBytes:
3B 8A 2C 7A AD CE 11 8C 4F 53 B3 2A 7F FD 73 79 
After shiftRows:
3B CE B3 79 AD 53 73 7A 4F FD 2C 8C 7F 8A 11 2A 
After mixColumns:
F5 0B 03 C2 BD E4 96 38 22 56 65 03 40 69 A9 4E 
After AddRoundKey(12):
B6 82 F8 08 48 DB 8C 21 40 A9 BF E1 81 07 D9 06 
After subBytes:
4E 13 41 30 52 B9 64 FD 09 D3 08 F8 0C C5 35 6F 
After shiftRows:
4E B9 08 6F 52 D3 35 30 09 C5 41 FD 0C 13 64 F8 
After AddRoundKey(14):
80 D2 FD CF 77 53 31 D0 C6 B5 B5 A7 A1 B0 09 3B 
After subBytes:
CD B5 54 8A F5 ED C7 70 B4 D5 D5 5C 32 E7 01 E2 
After shiftRows:
CD ED D5 E2 F5 D5 01 8A B4 E7 54 70 32 B5 C7 5C 
After mixColumns:
9A 8A AC AB 1E CD A7 DF 65 ED 6B 94 3B 4D F6 9C 
After AddRoundKey(13):
8C FC CE BF 9C 2F 46 C9 BA 45 C0 72 BD 3D 3F 18 
After subBytes:
64 B0 8B 08 DE 15 5A DD F4 6E BA 40 7A 27 75 AD 
After shiftRows:
64 15 BA AD DE 6E 75 08 F4 27 8B DD 7A B0 5A 40 
After AddRoundKey(14):
AA 5E 00 B9 DB EE D3 73 74 F5 7F 99 63 88 29 83 
