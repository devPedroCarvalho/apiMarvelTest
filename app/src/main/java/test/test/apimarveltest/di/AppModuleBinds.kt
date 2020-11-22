package test.test.apimarveltest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import test.test.apimarveltest.remoteDataSource.repository.details.CharacterDetailsRepository
import test.test.apimarveltest.remoteDataSource.repository.listCharacter.CharacterListRepository
import test.test.apimarveltest.remoteDataSource.repository.details.ICharacterDetailsRepository
import test.test.apimarveltest.remoteDataSource.repository.listCharacter.ICharacterListRepository

@InstallIn(ApplicationComponent::class)
@Module
abstract class AppModuleBinds {


    @Binds
    abstract fun bindCharacterDetailsRepository(repository: CharacterDetailsRepository): ICharacterDetailsRepository

    @Binds
    abstract fun characterListRepository(repository: CharacterListRepository): ICharacterListRepository

}