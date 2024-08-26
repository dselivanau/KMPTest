//
//  LoginView.swift
//  iosApp
//
//  Created by Denis Selivanov on 8/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginView: View {
    
    private let viewModel: LoginViewModel = LoginViewModel()
    
    @KMPState var loginState: LoginState
    @KMPState var isLoading: Bool
    
    init() {
        self._loginState = KMPState(stateFlow: viewModel.loginStateFlow, default: LoginState.Companion.shared.EMPTY)
        self._isLoading = KMPState(stateFlow: viewModel.isLoading, default: false)
    }
    
    var body: some View {
        VStack {
            TextField("Login", text: .init(get: {
                loginState.login
            }, set: { value in
                viewModel.onUpdateLogin(value: value)
            }))
            
            TextField("Password", text: .init(get: {
                loginState.password
            }, set: { value in
                viewModel.onUpdatePassword(value: value)
            }))
            
            ZStack {
                Button("Login") {
                    viewModel.loginClicked()
                }
                if isLoading {
                    HStack {
                        Spacer()
                        ProgressView()
                    }
                }
            }
            .frame(maxWidth: .infinity)
        }
    }
}

#Preview {
    LoginView()
}
