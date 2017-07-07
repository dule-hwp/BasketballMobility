[app](../../index.md) / [hwp.basketball.mobility.util](../index.md) / [com.google.firebase.auth.FirebaseUser](index.md) / [getFireBaseDBEmail](.)

# getFireBaseDBEmail

`fun FirebaseUser.getFireBaseDBEmail(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Firebase has certain characters which cannot be used as part of the key.
I wanted to organize data to be more browsable, and wanted to use email as key,
so i had to replace '.' with ',' and then used that value as key for users.

**Return**
Firebase user email whre '.' is replaced with ','

