package test.test.apimarveltest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import test.test.apimarveltest.remoteDataSource.repository.CharacterDetailsRepository
import test.test.apimarveltest.remoteDataSource.repository.ICharacterDetailsRepository

@InstallIn(ApplicationComponent::class)
@Module
abstract class AppModuleBinds {


    @Binds
    abstract fun bindCharacterDetailsRepository(repository: CharacterDetailsRepository): ICharacterDetailsRepository

}