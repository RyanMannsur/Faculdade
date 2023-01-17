/****************************************************************************
** Meta object code from reading C++ file 'Picaria.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.12.11)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../Picaria/Picaria.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'Picaria.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.12.11. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_Picaria_t {
    QByteArrayData data[28];
    char stringdata0[253];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Picaria_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Picaria_t qt_meta_stringdata_Picaria = {
    {
QT_MOC_LITERAL(0, 0, 7), // "Picaria"
QT_MOC_LITERAL(1, 8, 11), // "modeChanged"
QT_MOC_LITERAL(2, 20, 0), // ""
QT_MOC_LITERAL(3, 21, 13), // "Picaria::Mode"
QT_MOC_LITERAL(4, 35, 4), // "mode"
QT_MOC_LITERAL(5, 40, 8), // "gameOver"
QT_MOC_LITERAL(6, 49, 6), // "Player"
QT_MOC_LITERAL(7, 56, 6), // "player"
QT_MOC_LITERAL(8, 63, 12), // "phaseChanged"
QT_MOC_LITERAL(9, 76, 14), // "Picaria::Phase"
QT_MOC_LITERAL(10, 91, 5), // "phase"
QT_MOC_LITERAL(11, 97, 4), // "play"
QT_MOC_LITERAL(12, 102, 2), // "id"
QT_MOC_LITERAL(13, 105, 5), // "reset"
QT_MOC_LITERAL(14, 111, 9), // "showAbout"
QT_MOC_LITERAL(15, 121, 10), // "updateMode"
QT_MOC_LITERAL(16, 132, 8), // "QAction*"
QT_MOC_LITERAL(17, 141, 6), // "action"
QT_MOC_LITERAL(18, 148, 15), // "updateStatusBar"
QT_MOC_LITERAL(19, 164, 12), // "showGameOver"
QT_MOC_LITERAL(20, 177, 4), // "Mode"
QT_MOC_LITERAL(21, 182, 9), // "NineHoles"
QT_MOC_LITERAL(22, 192, 13), // "ThirteenHoles"
QT_MOC_LITERAL(23, 206, 9), // "RedPlayer"
QT_MOC_LITERAL(24, 216, 10), // "BluePlayer"
QT_MOC_LITERAL(25, 227, 5), // "Phase"
QT_MOC_LITERAL(26, 233, 9), // "DropPhase"
QT_MOC_LITERAL(27, 243, 9) // "MovePhase"

    },
    "Picaria\0modeChanged\0\0Picaria::Mode\0"
    "mode\0gameOver\0Player\0player\0phaseChanged\0"
    "Picaria::Phase\0phase\0play\0id\0reset\0"
    "showAbout\0updateMode\0QAction*\0action\0"
    "updateStatusBar\0showGameOver\0Mode\0"
    "NineHoles\0ThirteenHoles\0RedPlayer\0"
    "BluePlayer\0Phase\0DropPhase\0MovePhase"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Picaria[] = {

 // content:
       8,       // revision
       0,       // classname
       0,    0, // classinfo
       9,   14, // methods
       1,   80, // properties
       3,   84, // enums/sets
       0,    0, // constructors
       0,       // flags
       3,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    1,   59,    2, 0x06 /* Public */,
       5,    1,   62,    2, 0x06 /* Public */,
       8,    1,   65,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
      11,    1,   68,    2, 0x08 /* Private */,
      13,    0,   71,    2, 0x08 /* Private */,
      14,    0,   72,    2, 0x08 /* Private */,
      15,    1,   73,    2, 0x08 /* Private */,
      18,    0,   76,    2, 0x08 /* Private */,
      19,    1,   77,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void, 0x80000000 | 3,    4,
    QMetaType::Void, 0x80000000 | 6,    7,
    QMetaType::Void, 0x80000000 | 9,   10,

 // slots: parameters
    QMetaType::Void, QMetaType::Int,   12,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 16,   17,
    QMetaType::Void,
    QMetaType::Void, 0x80000000 | 6,    7,

 // properties: name, type, flags
       4, 0x80000000 | 3, 0x0049510b,

 // properties: notify_signal_id
       0,

 // enums: name, alias, flags, count, data
      20,   20, 0x0,    2,   99,
       6,    6, 0x0,    2,  103,
      25,   25, 0x0,    2,  107,

 // enum data: key, value
      21, uint(Picaria::NineHoles),
      22, uint(Picaria::ThirteenHoles),
      23, uint(Picaria::RedPlayer),
      24, uint(Picaria::BluePlayer),
      26, uint(Picaria::DropPhase),
      27, uint(Picaria::MovePhase),

       0        // eod
};

void Picaria::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        auto *_t = static_cast<Picaria *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->modeChanged((*reinterpret_cast< Picaria::Mode(*)>(_a[1]))); break;
        case 1: _t->gameOver((*reinterpret_cast< Player(*)>(_a[1]))); break;
        case 2: _t->phaseChanged((*reinterpret_cast< Picaria::Phase(*)>(_a[1]))); break;
        case 3: _t->play((*reinterpret_cast< int(*)>(_a[1]))); break;
        case 4: _t->reset(); break;
        case 5: _t->showAbout(); break;
        case 6: _t->updateMode((*reinterpret_cast< QAction*(*)>(_a[1]))); break;
        case 7: _t->updateStatusBar(); break;
        case 8: _t->showGameOver((*reinterpret_cast< Player(*)>(_a[1]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (Picaria::*)(Picaria::Mode );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&Picaria::modeChanged)) {
                *result = 0;
                return;
            }
        }
        {
            using _t = void (Picaria::*)(Player );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&Picaria::gameOver)) {
                *result = 1;
                return;
            }
        }
        {
            using _t = void (Picaria::*)(Picaria::Phase );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&Picaria::phaseChanged)) {
                *result = 2;
                return;
            }
        }
    }
#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty) {
        auto *_t = static_cast<Picaria *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: *reinterpret_cast< Picaria::Mode*>(_v) = _t->mode(); break;
        default: break;
        }
    } else if (_c == QMetaObject::WriteProperty) {
        auto *_t = static_cast<Picaria *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: _t->setMode(*reinterpret_cast< Picaria::Mode*>(_v)); break;
        default: break;
        }
    } else if (_c == QMetaObject::ResetProperty) {
    }
#endif // QT_NO_PROPERTIES
}

QT_INIT_METAOBJECT const QMetaObject Picaria::staticMetaObject = { {
    &QMainWindow::staticMetaObject,
    qt_meta_stringdata_Picaria.data,
    qt_meta_data_Picaria,
    qt_static_metacall,
    nullptr,
    nullptr
} };


const QMetaObject *Picaria::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Picaria::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Picaria.stringdata0))
        return static_cast<void*>(this);
    return QMainWindow::qt_metacast(_clname);
}

int Picaria::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QMainWindow::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 9)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 9;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 9)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 9;
    }
#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty || _c == QMetaObject::WriteProperty
            || _c == QMetaObject::ResetProperty || _c == QMetaObject::RegisterPropertyMetaType) {
        qt_static_metacall(this, _c, _id, _a);
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyDesignable) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyScriptable) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyStored) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyEditable) {
        _id -= 1;
    } else if (_c == QMetaObject::QueryPropertyUser) {
        _id -= 1;
    }
#endif // QT_NO_PROPERTIES
    return _id;
}

// SIGNAL 0
void Picaria::modeChanged(Picaria::Mode _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void Picaria::gameOver(Player _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}

// SIGNAL 2
void Picaria::phaseChanged(Picaria::Phase _t1)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)) };
    QMetaObject::activate(this, &staticMetaObject, 2, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
