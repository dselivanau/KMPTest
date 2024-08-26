//
// Copyright (c) New Cloud Technologies, Ltd., 2019-2024
//
// You can not use the contents of the file in any way without New Cloud Technologies, Ltd. written permission.
// To obtain such a permit, you should contact New Cloud Technologies, Ltd. at https://myoffice.ru/contacts/
//

import Foundation
import shared

public final class KMPStateObservable<Type, MappedType>: ObservableObject where Type: AnyObject {

    @Published public var value: MappedType

    private var cancelable: Cancelable?

    public init(
        _ flow: Flow,
        defaultValue: Type? = nil,
        mapping: @escaping (Type?) -> MappedType
    ) {
        if let coreStateFlow = flow as? StateFlow {
            value = mapping(coreStateFlow.value as? Type ?? defaultValue)
        } else {
            value = mapping(defaultValue)
        }

        cancelable = BindableFlow<Type>(flow: flow).bind { [weak self] newState in
            self?.value = mapping(newState)
        }
    }

    deinit {
        cancelable?.cancel()
    }
}
